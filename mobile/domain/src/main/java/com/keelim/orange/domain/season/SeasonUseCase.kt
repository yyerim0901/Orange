package com.keelim.orange.domain.season

import com.keelim.orange.data.model.Article
import com.keelim.orange.data.repository.season.SeasonRepository

class SeasonUseCase(
    private val seasonRepository: SeasonRepository,
) {
    suspend fun articleFeed(challenge: Int): List<Article> {
        return seasonRepository.article(challenge)
    }
}