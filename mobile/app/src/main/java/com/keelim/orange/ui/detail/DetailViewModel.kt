package com.keelim.orange.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.data.model.entity.Favorite
import com.keelim.orange.data.response.DetailResponse
import com.keelim.orange.domain.auth.FavoriteUseCase
import com.keelim.orange.domain.feed.GetDetailInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
  private val getDetailInformationUseCase: GetDetailInformationUseCase,
  private val favoriteUseCase: FavoriteUseCase,
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
        DetailResponse(
          "https://images.unsplash.com/photo-1511381939415-e44015466834?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=838&q=80",
          "이것은 샘플 정보입니다.",
          "이것은 샘플 정보입니다.이것은 샘플 정보입니다.이것은 샘플 정보입니다.이것은 샘플 정보입니다.이것은 샘플 정보입니다.이것은 샘플 정보입니다.이것은 샘플 정보입니다.이것은 샘플 정보입니다."
        )
        )
      )
    } catch (e: Exception) {
      setState(
        DetailState.Error
      )
    }
  }

  fun favoriteAdd(favorite: Favorite) = viewModelScope.launch{
    favoriteUseCase.insert(favorite)
  }

  private fun setState(value: DetailState) {
    _state.value = value
  }
}
