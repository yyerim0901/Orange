package com.keelim.orange.ui.profile.profile

import com.keelim.orange.data.model.Favorite

sealed class ProfileState {
  object UnInitialized : ProfileState()
  object Loading : ProfileState()
  data class Success(
    val ing: List<Favorite>,
    val completed: List<Favorite>
  ) : ProfileState()
  object Error : ProfileState()
}
