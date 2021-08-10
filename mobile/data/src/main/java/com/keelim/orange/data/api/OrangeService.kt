package com.keelim.orange.data.api

import com.keelim.orange.data.model.Favorite
import com.keelim.orange.data.response.DetailResponse
import com.keelim.orange.data.response.FriendsResponse
import com.keelim.orange.data.response.ResultResponse
import com.keelim.orange.data.response.UserSampleResponse
import com.keelim.orange.data.response.badge.BadgeResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface OrangeService {

  @Headers("Content-Type: application/json")
  @POST("other/sue/")
  fun sue(): Response<UserSampleResponse>

  @Headers("Content-Type: application/json")
  @POST("other/sue/")
  fun like(): Response<UserSampleResponse>

  @Headers("Content-Type: application/json")
  @POST("other/sue/")
  fun authenticate(): Response<UserSampleResponse>

  @Headers("Content-Type: application/json")
  @POST("other/sue/")
  fun share(): Response<UserSampleResponse>

  @Headers("Content-Type: application/json")
  @POST("create/upload/")
  fun upload(
    @Field("title") title: String,
    @Field("description") description: String
  ): Response<UserSampleResponse>

  @GET("detail/")
  fun detail(
    @Query("uid") uid: String
  ): Response<DetailResponse>

  @POST("invite/")
  fun invite(
    @Query("uid") uid: String
  ): Response<ResultResponse>

  @GET("friends/{myid}")
  fun getFriends(
    @Query("myid") id: String
  ): Response<FriendsResponse>

  @POST()
  fun getIngList(

  ):List<Favorite>

  @POST
  fun getCompletedList(

  ): List<Favorite>

  @GET("api/badge/list")
  fun getAllBadgeList():Response<BadgeResponse>

}
