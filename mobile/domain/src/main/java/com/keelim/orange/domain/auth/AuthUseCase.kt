package com.keelim.orange.domain.auth

import com.keelim.orange.data.model.LoggedInUser
import com.keelim.orange.data.model.Result
import com.keelim.orange.data.repository.LoginRepository
import javax.inject.Inject


class AuthUseCase(
    private val loginRepository: LoginRepository
) {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        return loginRepository.login(username, password)
    }

    suspend fun logout() {
        loginRepository.logout()
    }
}