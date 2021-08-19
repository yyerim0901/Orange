package com.keelim.orange.data.call

import com.google.gson.annotations.SerializedName

data class CreateCall(
  @SerializedName("articleContent")
  val articleContent: String,
  @SerializedName("challenge")
  val challenge: Int,
  @SerializedName("title")
  val title: String,
  @SerializedName("user")
  val user: Int,
  @SerializedName("verified")
  val verified: Boolean,
)
