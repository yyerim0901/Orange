package com.keelim.orange.data.datasource

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.model.LoggedInUser
import com.keelim.orange.data.model.Result
import com.keelim.orange.data.response.auth.SignUpResponse
import com.keelim.orange.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException
import java.util.UUID

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(
  @IoDispatcher private val dispatcher: CoroutineDispatcher,
  private val apiRequestFactory: ApiRequestFactory,
) {

  suspend fun login(username: String, password: String): Result<LoggedInUser> =
    withContext(dispatcher) {
      try {
        // TODO: handle loggedInUser authentication
        val fakeUser = LoggedInUser(UUID.randomUUID().toString(), "Jane Doe")
        return@withContext Result.Success(fakeUser)
      } catch (e: Throwable) {
        return@withContext Result.Error(IOException("Error logging in", e))
      }
    }

  suspend fun logout() {
    // TODO: revoke authentication
  }

  suspend fun signup(username: String, password: String, nickname: String): Result<LoggedInUser> = withContext(dispatcher) {
//      val result = apiRequestFactory.retrofit.signup(username, nickname, password)
//      if (result.isSuccessful) {
//        val data = result.body() ?: SignUpResponse("false")
//        Timber.d("[retrofit data] ${result.toString()}")
//        if (data.result == "success") {
//          return@withContext Result.Success(LoggedInUser(UUID.randomUUID().toString(), username))
//        }
//      }
      return@withContext Result.Error(IOException("Error logging in"))
    }
}
