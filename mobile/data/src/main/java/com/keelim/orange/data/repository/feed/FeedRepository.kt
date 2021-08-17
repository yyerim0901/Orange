package com.keelim.orange.data.repository.feed

import com.keelim.orange.data.response.DetailResponse
import com.keelim.orange.data.response.feed.CategoryResponse
import com.keelim.orange.data.response.feed.ChallengeResponse

interface FeedRepository {
  suspend fun getDetail(uid: String): DetailResponse
  suspend fun getCategory(): List<CategoryResponse>
  suspend fun challengeList(): List<ChallengeResponse>
}
