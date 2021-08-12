package com.keelim.orange.ui.profile.badge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.badge.GetAllBadgeListUseCase
import com.keelim.orange.domain.badge.MyBadgeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AllBadgeViewModel @Inject constructor(
    private val getAllBadgeListUseCase: GetAllBadgeListUseCase,
    private val myBadgeListUseCase: MyBadgeListUseCase,
): ViewModel() {
    private var _state = MutableLiveData<BadgeState>(BadgeState.UnInitialized)
    val state: LiveData<BadgeState> get() = _state

    fun fetchData(userId: Int) = viewModelScope.launch {
        setState(
            BadgeState.Loading
        )

        try {
            setState(
                BadgeState.Success(
                    getAllBadgeListUseCase.invoke(),
                    myBadgeListUseCase.invoke(userId)
                )
            )
        } catch (e: Exception) {
            setState(
                BadgeState.Error
            )
        }
    }

    private fun setState(state: BadgeState) {
        _state.value = state
    }
}