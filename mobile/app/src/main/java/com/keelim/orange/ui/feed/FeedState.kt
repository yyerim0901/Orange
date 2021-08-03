package com.keelim.orange.ui.feed

import com.keelim.orange.data.model.Fight

sealed class FeedState {
  object UnInitialized : FeedState()
  object Loading : FeedState()
  data class Success(
    val data: List<Fight>
  ) : FeedState()
  object Error : FeedState()
}
