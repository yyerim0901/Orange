package com.keelim.orange.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.theme.GetAppThemeUseCase
import com.keelim.orange.domain.theme.SetAppThemeUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(
  getTheme:GetAppThemeUseCase,
  private val setTheme: SetAppThemeUseCase,
): ViewModel(){
  val theme: LiveData<Int> = getTheme.appTheme.asLiveData()

  fun setAppTheme(theme: Int) = viewModelScope.launch {
    setTheme.invoke(theme)
  }

}