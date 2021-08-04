package com.keelim.orange.ui.friends

import com.keelim.orange.data.model.Friends

sealed class FriendsState {
  object UnInitialized : FriendsState()
  object Loading : FriendsState()
  data class Success(
    val data: List<Friends>
  ) : FriendsState()
  object InviteSuccess: FriendsState()
  object Error : FriendsState()
}
