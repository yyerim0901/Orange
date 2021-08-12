package com.keelim.orange.ui.auth.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.keelim.orange.common.toast
import com.keelim.orange.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {
  private var _binding: FragmentSignupBinding? = null
  private val binding get() = _binding!!
  private val signupViewModel: SignUpViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentSignupBinding.inflate(inflater, container, false)
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
        signupViewModel.loginDataChanged(
          username.text.toString(),
          password.text.toString(),
          passwordConfirmation.text.toString()
        )
      }
    }
    username.addTextChangedListener(afterTextChangedListener)
    password.addTextChangedListener(afterTextChangedListener)
    passwordConfirmation.addTextChangedListener(afterTextChangedListener)
    password.setOnEditorActionListener { _, actionId, _ ->
      if (actionId == EditorInfo.IME_ACTION_DONE) {
        signupViewModel.signup(
          username.text.toString(),
          password.text.toString()
        )
      }
      false
    }

    login.setOnClickListener {
      signupViewModel.signup(
        username.text.toString(),
        password.text.toString()
      )
    }
  }

  private fun observeData() {
    signupViewModel.loginFormState.observe(viewLifecycleOwner) { loginFormState ->
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

    signupViewModel.loginResult.observe(viewLifecycleOwner) { loginResult ->
      loginResult ?: return@observe
      loginResult.error?.let {
        requireContext().toast(it)
      }
      loginResult.success?.let {
        requireContext().toast("회원가입이 완료되었습니다.")
        findNavController().navigateUp()
      }
    }
  }
}
