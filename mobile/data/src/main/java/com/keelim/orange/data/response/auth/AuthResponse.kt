package com.keelim.orange.data.response.auth

import com.google.gson.annotations.SerializedName

data class AuthResponse(
  @SerializedName("data")
  val data: String?,
  @SerializedName("message")
  val message: String,
  @SerializedName("response")
  val response: String,
)
