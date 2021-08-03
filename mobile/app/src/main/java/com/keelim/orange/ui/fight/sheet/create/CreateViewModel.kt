package com.keelim.orange.ui.fight.sheet.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.orange.domain.fight.CreateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val createUseCase: CreateUseCase
): ViewModel() {

    fun upload(title:String, description:String) = viewModelScope.launch{
        createUseCase.upload(title, description)
    }
}