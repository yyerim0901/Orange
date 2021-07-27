package com.keelim.orange.ui.season

import com.keelim.orange.data.model.Fight

sealed class SeasonState{
    object UnInitialized:SeasonState()
    object Loading:SeasonState()
    data class Success(
        val data:List<Fight>
    ):SeasonState()
    object Error:SeasonState()
}
