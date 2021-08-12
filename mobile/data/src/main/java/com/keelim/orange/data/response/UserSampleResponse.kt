package com.keelim.orange.data.response

import com.google.gson.annotations.SerializedName

data class UserSampleResponse(
  @SerializedName("user_age")
  val userAge: Int,
  @SerializedName("user_email")
  val userEmail: String,
  @SerializedName("user_id")
  val userId: Int,
  @SerializedName("user_name")
  val userName: String,
  @SerializedName("user_uid")
  val userUid: String
)
