package com.keelim.orange.data.response

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("result")
    val result: String,
)