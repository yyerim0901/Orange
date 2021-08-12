package com.keelim.orange.domain.history

import com.keelim.orange.data.model.History
import com.keelim.orange.data.repository.history.HistoryRepository
import com.keelim.orange.data.repository.season.create.CreateRepository

class HistoryUseCase(
  private val historyRepository: HistoryRepository,
) {
  suspend fun getListAll():List<History>{
    return historyRepository.getAll()
  }

  suspend fun insert(history: History){
    return historyRepository.insertHistory(history)
  }

  suspend fun delete(history: History){
    return historyRepository.deleteHistory(history)
  }
}
