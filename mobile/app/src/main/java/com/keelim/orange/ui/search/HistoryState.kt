package com.keelim.orange.ui.search

import com.keelim.orange.data.model.History

sealed class HistoryState {
    object UnInitialized: HistoryState()
    object Loading: HistoryState()
    data class Success(
        val data:List<History>
    ): HistoryState()
    object Error: HistoryState()
}