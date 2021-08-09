package com.keelim.orange.ui.friends

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.FriendsOkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class FriendsViewModel @Inject constructor(
  private val friendsOkUseCase: FriendsOkUseCase,
) : ViewModel() {
  private val _state = MutableLiveData<FriendsState>()
  val state: LiveData<FriendsState> = _state

  fun fetchData(myId:String) = viewModelScope.launch{
    setState(
      FriendsState.UnInitialized
    )
    try {
      setState(
        FriendsState.Success(
          friendsOkUseCase.getFriends(myId).friends
        )
      )
    } catch (e: Exception) {
      setState(
        FriendsState.Error
      )
    }
  }

  fun invite(myId:String, uid:String) = viewModelScope.launch {
      try {
          val result = friendsOkUseCase.invite(myId, uid)
          if(result.result=="false"){
              setState(
                  FriendsState.Error
              )
          } else{
              setState(
                  FriendsState.InviteSuccess
              )
          }
      } catch (e:Exception){
          setState(
              FriendsState.Error
          )
      }
  }

  private fun setState(value: FriendsState) {
    _state.value = value
  }
}
