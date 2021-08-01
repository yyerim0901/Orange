package com.keelim.orange.ui.season.ranking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.season.RankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
  private val rankingUseCase: RankingUseCase,
) : ViewModel() {
  private var _state = MutableLiveData<RankingState>(RankingState.UnInitialized)
  val state: LiveData<RankingState> = _state

  fun fetchData() = viewModelScope.launch {
    setState(
      RankingState.Loading
    )

    try {
      setState(
        RankingState.Success(
          rankingUseCase.invoke()
        )
      )
    } catch (e: Exception) {
      setState(
        RankingState.Error
      )
    }
  }

  private fun setState(state: RankingState) {
    _state.value = state
  }
}
