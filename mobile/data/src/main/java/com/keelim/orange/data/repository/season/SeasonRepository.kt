package com.keelim.orange.data.repository.season

import com.keelim.orange.data.model.Article

interface SeasonRepository {
    suspend fun article(challenge:Int):List<Article>
    suspend fun image(article: Int):String?
}