package com.keelim.orange.data.model

data class Favorite(
  val imageLink: String,
  val title: String,
  val level: String,
  val challengeId: Int,
  val rating: Float,
  var isFull:Boolean,
)
