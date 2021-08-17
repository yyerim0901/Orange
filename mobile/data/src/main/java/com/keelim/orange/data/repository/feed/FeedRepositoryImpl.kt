package com.keelim.orange.data.repository.feed

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.response.DetailResponse
import com.keelim.orange.data.response.feed.CategoryResponse
import com.keelim.orange.data.response.feed.ChallengeResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class FeedRepositoryImpl(
  private val apiRequestFactory: ApiRequestFactory,
  private val dispatcher: CoroutineDispatcher,
) : FeedRepository {
  override suspend fun getDetail(uid: String): DetailResponse = withContext(dispatcher) {
    return@withContext apiRequestFactory.retrofit.detail(uid).body() ?: DetailResponse(img_url = "", title = "", description = "")
  }

  override suspend fun getCategory(): List<CategoryResponse> = withContext(dispatcher) {
    apiRequestFactory.retrofit.category().body() ?: listOf()
  }

  override suspend fun challengeList(): List<ChallengeResponse> = withContext(dispatcher) {
    apiRequestFactory.retrofit.challengeList().body() ?: listOf()
    emptyList()
  }
}
