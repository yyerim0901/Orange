package com.keelim.orange.data.model

import com.google.gson.annotations.SerializedName

data class Friends(
    @SerializedName("img_url")
    val img_url:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("uid")
    val uid:String,
)
