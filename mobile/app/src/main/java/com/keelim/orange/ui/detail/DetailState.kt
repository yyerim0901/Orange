package com.keelim.orange.ui.detail

import com.keelim.orange.data.response.DetailResponse

sealed class DetailState {
  object UnInitialized : DetailState()
  object Loading : DetailState()
  data class Success(
    val data: DetailResponse
  ) : DetailState()
  object Error : DetailState()
}
