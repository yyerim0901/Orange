package com.keelim.orange.data.api

import com.keelim.orange.data.call.ChallengeCall
import com.keelim.orange.data.call.LoginCall
import com.keelim.orange.data.call.SignUpCall
import com.keelim.orange.data.model.entity.Favorite
import com.keelim.orange.data.response.DetailResponse
import com.keelim.orange.data.response.FriendsResponse
import com.keelim.orange.data.response.ProfileResponse
import com.keelim.orange.data.response.ResultResponse
import com.keelim.orange.data.response.UserSampleResponse
import com.keelim.orange.data.response.auth.AuthResponse
import com.keelim.orange.data.response.badge.BadgeResponse
import com.keelim.orange.data.response.feed.CategoryResponse
import com.keelim.orange.data.response.feed.ChallengeResponse
import com.keelim.orange.data.response.notification.NotificationDeleteResponse
import com.keelim.orange.data.response.notification.NotificationResponse
import com.keelim.orange.data.response.ranking.RankingResponse
import com.keelim.orange.data.response.search.SearchResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
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
  fun getIngList(): List<Favorite>

  @POST
  fun getCompletedList(): List<Favorite>

  @GET("api/badge/list")
  suspend fun getAllBadgeList(): Response<BadgeResponse>

  @GET("api/badge/list/{userId}")
  suspend fun getMyBadge(
    @Path("userId") userId: Int
  ): Response<BadgeResponse>

  @GET("api/notification/select/{userId}")
  suspend fun getNotificationList(@Path("userId") userId: Int): Response<List<NotificationResponse>>

  @POST("api/user/signup")
  suspend fun signup(
    @Body call: SignUpCall
  ): Response<AuthResponse>

  @POST("api/user/login")
  suspend fun login(
    @Body call: LoginCall,
  ): Response<AuthResponse>

  @GET("api/challenge/ranking/point")
  suspend fun getPointRanking(): Response<List<RankingResponse>>

  @GET("api/challenge/ranking/startdate")
  suspend fun getStartRanking(): Response<List<RankingResponse>>

  @GET("api/category/list")
  suspend fun category(): Response<List<CategoryResponse>>

  @DELETE("/api/notification/delete/{notificationId}")
  suspend fun deleteNoti(@Path("notificationId") notificationId: Int): Response<NotificationDeleteResponse>

  @GET("api/challenge/list")
  suspend fun challengeList(): Response<List<ChallengeResponse>>


  @GET("api/challenge/search/title/{searchTitle}")
  suspend fun search(@Path(value = "searchTitle", encoded = true) query: String): Response<List<SearchResponse>>

  @POST("api/challenge/register/new-challenge")
  suspend fun createChallengeList(
    @Body call: ChallengeCall,
  ): Response<ResultResponse>


  @GET("/api/user/userinfo/{userId}")
  suspend fun profile(@Path("userId") userId: Int): Response<ProfileResponse>
}
