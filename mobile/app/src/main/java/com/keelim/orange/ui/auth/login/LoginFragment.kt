package com.keelim.orange.ui.auth.login

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.keelim.orange.R
import com.keelim.orange.common.toast
import com.keelim.orange.databinding.FragmentLoginBinding
import com.keelim.orange.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
  private var _binding: FragmentLoginBinding? = null
  private val binding get() = _binding!!
  private val loginViewModel: LoginViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentLoginBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initViews()
    observeData()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun initViews() = with(binding) {
    val afterTextChangedListener = object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        // ignore
      }

      override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        // ignore
      }

      override fun afterTextChanged(s: Editable) {
        loginViewModel.loginDataChanged(
          username.text.toString(),
          password.text.toString()
        )
      }
    }
    username.addTextChangedListener(afterTextChangedListener)
    password.addTextChangedListener(afterTextChangedListener)
    password.setOnEditorActionListener { _, actionId, _ ->
      if (actionId == EditorInfo.IME_ACTION_DONE) {
        loginViewModel.login(
          username.text.toString(),
          password.text.toString()
        )
      }
      false
    }

    login.setOnClickListener {
      loginViewModel.login(
        username.text.toString(),
        password.text.toString()
      )

      requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
    }

    btnKakaoLogin.setOnClickListener {
      auth()
    }

    btnSignup.setOnClickListener {
      findNavController().navigate(R.id.signUpFragment)
    }
  }

  private fun observeData() {
    loginViewModel.loginFormState.observe(viewLifecycleOwner) { loginFormState ->
      if (loginFormState == null) {
        return@observe
      }
      binding.login.isEnabled = loginFormState.isDataValid
      loginFormState.usernameError?.let {
        binding.username.error = getString(it)
      }
      loginFormState.passwordError?.let {
        binding.password.error = getString(it)
      }
    }

    loginViewModel.loginResult.observe(viewLifecycleOwner) { loginResult ->

      loginResult ?: return@observe
      loginResult.error?.let {
        requireContext().toast(it)
      }
      loginResult.success?.let {
        updateUiWithUser(it)
      }
    }
  }

  private fun updateUiWithUser(model: LoggedInUserView) {
    val welcome = getString(R.string.welcome) + model.displayName
    requireActivity().toast(welcome)
    requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
    requireActivity().finish()
  }

  private val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
    if (error != null) {
      Log.e(TAG, "로그인 실패", error)
      requireContext().toast("이런")
      requireActivity().finish()
    } else if (token != null) {
      Log.i(TAG, "로그인 성공 ${token.accessToken}")
      loginViewModel.sendTokenToServer(token)
      requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
      requireActivity().finish()
    }
  }

//   카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
  private fun auth() {
    if (UserApiClient.instance.isKakaoTalkLoginAvailable(requireContext())) {
      UserApiClient.instance.loginWithKakaoTalk(requireContext(), callback = callback)
    } else {
      UserApiClient.instance.loginWithKakaoAccount(requireContext(), callback = callback)
    }
  }
}
