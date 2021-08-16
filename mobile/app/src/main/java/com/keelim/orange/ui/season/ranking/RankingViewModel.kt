package com.keelim.orange.ui.season.ranking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.season.RankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class RankingViewModel @Inject constructor(
  private val rankingUseCase: RankingUseCase,
) : ViewModel() {
  private val _state = MutableLiveData<RankingState>(RankingState.UnInitialized)
  val state: LiveData<RankingState> get() = _state

  fun fetchData() = viewModelScope.launch {
    setState(
      RankingState.Loading
    )

    try {
      setState(
        RankingState.Success1(
          rankingUseCase.start()
        )
      )

      setState(
        RankingState.Success2(
          rankingUseCase.point()
        )
      )
    } catch (e: Exception) {
      setState(
        RankingState.Error
      )
    }
  }

  private fun setState(value: RankingState) {
    _state.value = value
  }
}
