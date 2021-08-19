package com.keelim.orange.data.repository.season

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.model.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SeasonRepositoryImpl(
    private val dispatcher: CoroutineDispatcher,
    private val apiRequestFactory: ApiRequestFactory,
) : SeasonRepository {
    override suspend fun article(challenge: Int): List<Article> = withContext(dispatcher) {
        val response = apiRequestFactory.retrofit.article(challenge)
        if (response.isSuccessful) {
            return@withContext response.body()?.map {
                Article(
                    it.articleContent,
                    it.articleId,
                    it.articleWritetime,
                    it.challenge,
                    it.title,
                    it.user,
                    it.verified,
                    "",
                )
            } ?: emptyList()
        } else {
            return@withContext emptyList()
        }
    }

    override suspend fun image(article: Int): String = withContext(dispatcher) {
        val response = apiRequestFactory.retrofit.image(article)
        return@withContext if (response.isSuccessful) {
            response.body()?.result ?: ""
        } else {
            ""
        }
    }
}
