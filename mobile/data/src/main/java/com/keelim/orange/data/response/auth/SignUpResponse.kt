package com.keelim.orange.data.response.auth


import com.google.gson.annotations.SerializedName

data class SignUpResponse(
  @SerializedName("result")
  val result: String
)