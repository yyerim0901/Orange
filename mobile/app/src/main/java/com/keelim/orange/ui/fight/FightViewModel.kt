package com.keelim.orange.ui.fight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keelim.orange.domain.feed.GetDetailInformationUseCase
import com.keelim.orange.domain.fight.OpponentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FightViewModel @Inject constructor(
  private val getDetailInformationUseCase: GetDetailInformationUseCase,
  private val opponentUseCase: OpponentUseCase,
) : ViewModel() {
  private val _state = MutableLiveData<FightState>()
  val state: LiveData<FightState> = _state

  fun fetchData(challengeId:Int) {
    setState(
      FightState.UnInitialized
    )
    try {
      setState(
        FightState.Success(
          emptyList()
          // todo
        )
      )
    } catch (e: Exception) {
      setState(
        FightState.Error
      )
    }
  }

  private fun setState(value: FightState) {
    _state.value = value
  }
}
