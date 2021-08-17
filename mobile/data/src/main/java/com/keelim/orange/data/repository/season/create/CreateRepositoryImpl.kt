package com.keelim.orange.data.repository.season.create

import com.keelim.orange.data.api.ApiRequestFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CreateRepositoryImpl(
  private val dispatcher: CoroutineDispatcher,
  private val apiRequestFactory: ApiRequestFactory
) : CreateRepository {
  override suspend fun upload(title: String, description: String): Boolean = withContext(dispatcher) {

    apiRequestFactory.retrofit.upload(title, description)
    false
  }
}
