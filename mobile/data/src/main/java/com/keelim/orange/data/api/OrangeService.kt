package com.keelim.orange.data.api

import com.keelim.orange.data.response.DetailResponse
import com.keelim.orange.data.response.UserSampleResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface OrangeService {

    @Headers("Content-Type: application/json")
    @POST("other/sue/")
    fun sue(
    ): Response<UserSampleResponse>

    @Headers("Content-Type: application/json")
    @POST("other/sue/")
    fun like(
    ): Response<UserSampleResponse>

    @Headers("Content-Type: application/json")
    @POST("other/sue/")
    fun authenticate(
    ): Response<UserSampleResponse>

    @Headers("Content-Type: application/json")
    @POST("other/sue/")
    fun share(
    ): Response<UserSampleResponse>

    @Headers("Content-Type: application/json")
    @POST("create/upload/")
    fun upload(
        @Field("title") title: String,
        @Field("description") description: String
    ): Response<UserSampleResponse>

    @GET("detail/")
    fun detail(
        @Query("uid") uid:String
    ): Response<DetailResponse>

}
