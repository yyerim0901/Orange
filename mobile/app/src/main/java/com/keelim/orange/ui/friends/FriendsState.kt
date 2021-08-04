package com.keelim.orange.ui.friends

import com.keelim.orange.data.model.Fight

sealed class FightState {
  object UnInitialized : FightState()
  object Loading : FightState()
  data class Success(
    val data: List<Fight>
  ) : FightState()
  object Error : FightState()
}
