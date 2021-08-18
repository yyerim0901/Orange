package com.keelim.orange.ui.profile.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.profile.GetIngChallengeUseCase
import com.keelim.orange.domain.profile.ProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getIngChallengeUseCase: GetIngChallengeUseCase,
    private val profileUseCase: ProfileUseCase,
) : ViewModel() {
    private var _state = MutableLiveData<ProfileState>(ProfileState.UnInitialized)
    val state: LiveData<ProfileState> get() = _state

    fun fetchData(userId: Int) = viewModelScope.launch {
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

            setState(
                ProfileState.ProfileSuccess(
                    profileUseCase.invoke(userId)
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