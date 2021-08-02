package com.keelim.orange.domain.season

import com.keelim.orange.data.model.Ranking
import com.keelim.orange.data.repository.season.RankingRepository

class RankingUseCase(
  private val rankingRepository: RankingRepository
) {
  suspend operator fun invoke(): List<Ranking> {
    return rankingRepository.getRanking()
  }
}
