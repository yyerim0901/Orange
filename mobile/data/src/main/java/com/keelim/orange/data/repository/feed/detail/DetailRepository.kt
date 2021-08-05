package com.keelim.orange.data.repository.feed.detail

import com.keelim.orange.data.response.DetailResponse

interface DetailRepository {
    suspend fun getDetail(uid:String): DetailResponse
}