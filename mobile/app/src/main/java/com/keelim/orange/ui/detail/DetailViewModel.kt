package com.keelim.orange.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.feed.GetDetailInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
  private val getDetailInformationUseCase: GetDetailInformationUseCase
) : ViewModel() {
  private val _state = MutableLiveData<DetailState>()
  val state: LiveData<DetailState> = _state

  fun fetchData(uid:String) = viewModelScope.launch{
    setState(
      DetailState.UnInitialized
    )
    try {
      setState(
        DetailState.Success(
          getDetailInformationUseCase.invoke(uid)
        )
      )
    } catch (e: Exception) {
      setState(
        DetailState.Error
      )
    }
  }

  private fun setState(value: DetailState) {
    _state.value = value
  }
}
