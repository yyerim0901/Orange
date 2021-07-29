package com.keelim.orange.ui.auth.signup

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.data.model.Result
import com.keelim.orange.data.repository.LoginRepository
import com.keelim.orange.ui.auth.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val loginRepository: LoginRepository
) : ViewModel() {

  private val _loginForm = MutableLiveData<LoginFormState>()
  val loginFormState: LiveData<LoginFormState> = _loginForm

  private val _loginResult = MutableLiveData<LoginResult>()
  val loginResult: LiveData<LoginResult> = _loginResult

  fun login(username: String, password: String) = viewModelScope.launch {
    // can be launched in a separate asynchronous job
    val result = loginRepository.login(username, password)
    when (result) {
      is Result.Success -> {
        setLoginResult(
          LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        )
      }
      is Result.Error -> {
        setLoginResult(
          LoginResult(error = R.string.login_failed)
        )
      }
    }
  }

  fun loginDataChanged(username: String, password: String) = viewModelScope.launch {
    when {
      !isUserNameValid(username) -> setLoginForm(LoginFormState(usernameError = R.string.invalid_username))
      !isPasswordValid(password) -> setLoginForm(LoginFormState(passwordError = R.string.invalid_password))
      else -> setLoginForm(LoginFormState(isDataValid = true))
    }
  }

  private fun setLoginResult(value: LoginResult) {
    _loginResult.value = value
  }

  private fun setLoginForm(value: LoginFormState) {
    _loginForm.value = value
  }

  // A placeholder username validation check
  private fun isUserNameValid(username: String): Boolean {
    return if (username.contains("@")) {
      Patterns.EMAIL_ADDRESS.matcher(username).matches()
    } else {
      username.isNotBlank()
    }
  }

  // A placeholder password validation check
  private fun isPasswordValid(password: String): Boolean {
    return password.length > 5
  }
}
