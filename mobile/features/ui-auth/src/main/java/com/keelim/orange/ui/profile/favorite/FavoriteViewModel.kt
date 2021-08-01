package com.keelim.orange.ui.profile.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.auth.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
  private val favoriteUseCase: FavoriteUseCase,
) : ViewModel() {
  private val _state = MutableLiveData<FavoriteState>(FavoriteState.UnInitialized)
  val state: LiveData<FavoriteState> get() = _state

  fun fetchData() = viewModelScope.launch {
    setState(
      FavoriteState.Loading
    )

    try {
      setState(
        FavoriteState.Success(
          favoriteUseCase.invoke()
        )
      )
    } catch (e: Exception) {
      setState(
        FavoriteState.Error
      )
    }
  }

  private fun setState(value: FavoriteState) {
    _state.value = value
  }
}
