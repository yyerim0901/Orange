package com.keelim.orange.ui.profile.badge

import com.keelim.orange.data.model.Badge

sealed class BadgeState {
  object UnInitialized : BadgeState()
  object Loading : BadgeState()
  data class Success(
    val data: List<Badge>
  ) : BadgeState()
  object Error : BadgeState()
}

