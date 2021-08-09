package com.keelim.orange.data.repository.history

import com.keelim.orange.data.model.History

interface HistoryRepository {
    suspend fun getAll(): List<History>
    suspend fun insertHistory(history: History)
    suspend fun deleteHistory(history: History)
}