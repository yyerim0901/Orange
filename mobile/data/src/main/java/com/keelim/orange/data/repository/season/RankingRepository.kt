package com.keelim.orange.data.repository.season

import com.keelim.orange.data.model.Ranking
import com.keelim.orange.di.IoDispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RankingRepository(
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun getSeason(): List<Ranking> = withContext(dispatcher) {
        emptyList()
    }
}