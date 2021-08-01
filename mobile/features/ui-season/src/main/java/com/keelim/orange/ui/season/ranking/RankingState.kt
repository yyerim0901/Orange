package com.keelim.orange.ui.season.ranking

import com.keelim.orange.data.model.Ranking

sealed class RankingState {
  object UnInitialized : RankingState()
  object Loading : RankingState()
  object Error : RankingState()
  data class Success(
    val data: List<Ranking>
  ) : RankingState()
}
