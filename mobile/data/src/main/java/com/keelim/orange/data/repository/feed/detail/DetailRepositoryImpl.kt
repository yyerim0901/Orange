package com.keelim.orange.data.repository.feed.detail

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.response.DetailResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DetailRepositoryImpl(
    private val apiRequestFactory: ApiRequestFactory,
    private val dispatcher: CoroutineDispatcher,
) : DetailRepository {
    override suspend fun getDetail(uid: String): DetailResponse = withContext(dispatcher){
        return@withContext apiRequestFactory.retrofit.detail(uid).body() ?: DetailResponse(img_url = "", title = "",description = "")
    }
}