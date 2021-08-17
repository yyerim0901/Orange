package com.keelim.orange.data.repository.search

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.model.Search
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SearchRepositoryImpl(
  private val dispatcher: CoroutineDispatcher,
  private val apiRequestFactory: ApiRequestFactory,
) : SearchRepository {
  override suspend fun search(query: String): List<Search> = withContext(dispatcher) {
    val response = apiRequestFactory.retrofit.search(query)
    if (response.isSuccessful) {
      return@withContext response.body()?.map {
        Search(
          uid = it.challengeId,
          title = it.challengeTitle,
          number = it.currentMembers.toString()
        )
      } ?: emptyList()
    } else {
      return@withContext emptyList()
    }
  }
}
