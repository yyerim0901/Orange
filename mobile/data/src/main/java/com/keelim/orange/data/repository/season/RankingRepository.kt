package com.keelim.orange.data.repository.season

import com.keelim.orange.data.model.Ranking
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RankingRepository(
  private val dispatcher: CoroutineDispatcher
) {
  suspend fun getSeason(): List<Ranking> = withContext(dispatcher) {
    emptyList()
  }

  suspend fun getRanking():List<Ranking> = withContext(dispatcher){
    emptyList()
  }
}
