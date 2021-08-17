package com.keelim.orange.data.repository.profile

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.model.entity.Favorite
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ProfileRepositoryImpl(
  private val dispatcher: CoroutineDispatcher,
  private val apiRequestFactory: ApiRequestFactory,
) : ProfileRepository {
  override suspend fun getIngChallengeList(): List<Favorite> = withContext(dispatcher) {
    return@withContext apiRequestFactory.retrofit.getIngList()
  }

  override suspend fun getCompletedChallengeList(): List<Favorite> = withContext(dispatcher) {
    return@withContext apiRequestFactory.retrofit.getCompletedList()
  }
}
