package com.keelim.orange.domain.season

import com.keelim.orange.data.model.Ranking
import com.keelim.orange.data.repository.season.RankingRepository
import timber.log.Timber

class RankingUseCase(
  private val rankingRepository: RankingRepository
) {
  suspend fun ranking():List<Ranking>{
    return rankingRepository.point()
  }

  suspend fun start():List<Ranking>{
    return rankingRepository.start()
  }
}
