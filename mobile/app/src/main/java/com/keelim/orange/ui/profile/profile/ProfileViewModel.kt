package com.keelim.orange.ui.profile.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.profile.GetCompletedChallengeUseCase
import com.keelim.orange.domain.profile.GetIngChallengeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getIngChallengeUseCase: GetIngChallengeUseCase,
    private val getCompletedChallengeUseCase: GetCompletedChallengeUseCase
) : ViewModel() {
    private var _state = MutableLiveData<ProfileState>(ProfileState.UnInitialized)
    val state: LiveData<ProfileState> get() = _state

    fun fetchData() = viewModelScope.launch {
        setState(
            ProfileState.Loading
        )

        try {
            setState(
                ProfileState.Success(
                    emptyList(),
                    emptyList()
                )
            )
        } catch (e: Exception) {
            setState(
                ProfileState.Error
            )
        }
    }

    private fun setState(state: ProfileState) {
        _state.value = state
    }
}