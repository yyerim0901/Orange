package com.keelim.orange.domain.season

import com.keelim.orange.data.model.season.Article
import com.keelim.orange.data.model.season.Comment
import com.keelim.orange.data.repository.season.SeasonRepository

class SeasonUseCase(
    private val seasonRepository: SeasonRepository,
) {
    suspend fun articleFeed(challenge: Int): List<Article> {
        return seasonRepository.article(challenge)
    }

    suspend fun getComments(articleId:Int): List<Comment>{
        return seasonRepository.comments(articleId)
    }


}