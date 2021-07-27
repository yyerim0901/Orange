package com.keelim.orange.ui.season

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeasonViewModel @Inject constructor(
    
) : ViewModel() {
    private val _state = MutableLiveData<SeasonState>()
    val state: LiveData<SeasonState> = _state

    fun fetchData() {
        setState(
            SeasonState.UnInitialized
        )
        try {
            setState(
                SeasonState.Success(
                    emptyList()
                    //todo
                )
            )
        } catch (e: Exception) {
            setState(
                SeasonState.Error
            )
        }
    }

    private fun setState(value: SeasonState) {
        _state.value = value
    }
}