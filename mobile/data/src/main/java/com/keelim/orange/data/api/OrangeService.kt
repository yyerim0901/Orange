package com.keelim.orange.data.api

import com.keelim.orange.data.response.UserSampleResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.Headers
import retrofit2.http.POST

interface OrangeService {

    @Headers("Content-Type: application/json")
    @POST("other/sue/")
    fun sue(
    ): Call<UserSampleResponse>

    @Headers("Content-Type: application/json")
    @POST("other/sue/")
    fun like(
    ): Call<UserSampleResponse>

    @Headers("Content-Type: application/json")
    @POST("other/sue/")
    fun authenticate(
    ): Call<UserSampleResponse>

    @Headers("Content-Type: application/json")
    @POST("other/sue/")
    fun share(
    ): Call<UserSampleResponse>

    @Headers("Content-Type: application/json")
    @POST("create/upload/")
    fun upload(
        @Field("title") title: String,
        @Field("description") description: String
    ): Call<UserSampleResponse>
}
