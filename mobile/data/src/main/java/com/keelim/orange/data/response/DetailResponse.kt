package com.keelim.orange.data.response

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("img_url")
    val img_url: String,

    @SerializedName("tile")
    val title: String,

    @SerializedName("description")
    val description: String,
)