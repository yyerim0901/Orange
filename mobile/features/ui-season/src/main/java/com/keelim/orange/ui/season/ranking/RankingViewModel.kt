package com.keelim.orange.ui.season.ranking

import androidx.lifecycle.ViewModel
import com.keelim.orange.domain.season.RankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val rankingUseCase: RankingUseCase,
):ViewModel()  {
}