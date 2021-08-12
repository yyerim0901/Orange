package com.keelim.orange.data.repository.friends

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.response.FriendsResponse
import com.keelim.orange.data.response.ResultResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class FriendsRepositoryImpl(
  private val dispatcher: CoroutineDispatcher,
  private val apiRequestFactory: ApiRequestFactory,
) : FriendsRepository {
  override suspend fun sendInvite(myId: String, uid: String): ResultResponse =
    withContext(dispatcher) {
      return@withContext apiRequestFactory.retrofit.invite(uid).body()
        ?: ResultResponse("false")
    }

  override suspend fun getFriends(myId: String): FriendsResponse = withContext(dispatcher) {
    return@withContext apiRequestFactory.retrofit.getFriends(myId).body()
      ?: FriendsResponse(
        emptyList()
      )
  }
}
