package com.keelim.orange.data.response

import com.google.gson.annotations.SerializedName
import com.keelim.orange.data.model.Friends

data class FriendsResponse(
  @SerializedName("friends")
  val friends: List<Friends>,
)
