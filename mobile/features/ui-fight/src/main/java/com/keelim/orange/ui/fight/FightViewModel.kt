package com.keelim.orange.ui.fight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FightViewModel @Inject constructor(
    
) : ViewModel() {
    private val _state = MutableLiveData<FightState>()
    val state: LiveData<FightState> = _state

    fun fetchData() {
        setState(
            FightState.UnInitialized
        )
        try {
            setState(
                FightState.Success(
                    emptyList()
                    //todo
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