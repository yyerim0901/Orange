package com.keelim.orange.ui.auth.signup


sealed class SignUpState {
    object UnInitialized : SignUpState()
    object Loading : SignUpState()
    object Error : SignUpState()
    object Success : SignUpState()
}
