package com.keelim.orange.data.repository.season

import com.keelim.orange.data.model.Ranking
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface RankingRepository{
  suspend fun point(): List<Ranking>
  suspend fun start(): List<Ranking>
}
