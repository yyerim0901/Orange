package com.keelim.orange.data.response.feed

import com.google.gson.annotations.SerializedName

data class ChallengeResponse(
  @SerializedName("articlesList")
  val articlesList: List<Articles>,
  @SerializedName("categoryId")
  val categoryId: Int,
  @SerializedName("challengeDescribe")
  val challengeDescribe: String,
  @SerializedName("challengeId")
  val challengeId: Int,
  @SerializedName("challengeTitle")
  val challengeTitle: String,
  @SerializedName("currentMembers")
  val currentMembers: Int,
  @SerializedName("endDate")
  val endDate: String,
  @SerializedName("imagePath")
  val imagePath: String,
  @SerializedName("managerId")
  val managerId: Int,
  @SerializedName("maxMembers")
  val maxMembers: Int,
  @SerializedName("minMembers")
  val minMembers: Int,
  @SerializedName("periodId")
  val periodId: Int,
  @SerializedName("startDate")
  val startDate: String,
  @SerializedName("totalPoint")
  val totalPoint: Int,
  @SerializedName("usersChallengesList")
  val usersChallengesList: List<UsersChallenges>
) {
  data class Articles(
    @SerializedName("articleContent")
    val articleContent: String,
    @SerializedName("articleId")
    val articleId: Int,
    @SerializedName("articleWritetime")
    val articleWritetime: String,
    @SerializedName("challenge")
    val challenge: Int,
    @SerializedName("commentsList")
    val commentsList: List<Comments>,
    @SerializedName("imagesList")
    val imagesList: List<Images>,
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: Int,
    @SerializedName("verified")
    val verified: Boolean
  ) {
    data class Comments(
      @SerializedName("article")
      val article: Int,
      @SerializedName("commentContent")
      val commentContent: String,
      @SerializedName("commentId")
      val commentId: Int,
      @SerializedName("commentWritetime")
      val commentWritetime: String,
      @SerializedName("user")
      val user: User
    ) {
      data class User(
        @SerializedName("articlesList")
        val articlesList: List<Any>,
        @SerializedName("badgesUsersList")
        val badgesUsersList: List<BadgesUsers>,
        @SerializedName("commentsList")
        val commentsList: List<Any>,
        @SerializedName("email")
        val email: String,
        @SerializedName("followerList")
        val followerList: List<Follower>,
        @SerializedName("followingList")
        val followingList: List<Following>,
        @SerializedName("nickname")
        val nickname: String,
        @SerializedName("notificationsList")
        val notificationsList: List<Notifications>,
        @SerializedName("password")
        val password: String,
        @SerializedName("profileImagePath")
        val profileImagePath: String,
        @SerializedName("role")
        val role: String,
        @SerializedName("salt")
        val salt: Salt,
        @SerializedName("token")
        val token: String,
        @SerializedName("userId")
        val userId: Int,
        @SerializedName("username")
        val username: String,
        @SerializedName("usersChallengesList")
        val usersChallengesList: List<Any>
      ) {
        data class BadgesUsers(
          @SerializedName("badge")
          val badge: Int,
          @SerializedName("badgeCount")
          val badgeCount: Int,
          @SerializedName("id")
          val id: Int,
          @SerializedName("representBadge")
          val representBadge: Boolean,
          @SerializedName("user")
          val user: Int
        )

        data class Follower(
          @SerializedName("followId")
          val followId: Int
        )

        data class Following(
          @SerializedName("followId")
          val followId: Int
        )

        data class Notifications(
          @SerializedName("notificationContent")
          val notificationContent: String,
          @SerializedName("notificationId")
          val notificationId: Int,
          @SerializedName("notificationTitle")
          val notificationTitle: String
        )

        data class Salt(
          @SerializedName("id")
          val id: Int,
          @SerializedName("salt")
          val salt: String
        )
      }
    }

    data class Images(
      @SerializedName("id")
      val id: Int,
      @SerializedName("imagePath")
      val imagePath: String
    )
  }

  data class UsersChallenges(
    @SerializedName("id")
    val id: Int,
    @SerializedName("manager")
    val manager: Boolean,
    @SerializedName("point")
    val point: Int,
    @SerializedName("user")
    val user: User
  ) {
    data class User(
      @SerializedName("articlesList")
      val articlesList: List<Any>,
      @SerializedName("badgesUsersList")
      val badgesUsersList: List<BadgesUsers>,
      @SerializedName("commentsList")
      val commentsList: List<Any>,
      @SerializedName("email")
      val email: String,
      @SerializedName("followerList")
      val followerList: List<Follower>,
      @SerializedName("followingList")
      val followingList: List<Following>,
      @SerializedName("nickname")
      val nickname: String,
      @SerializedName("notificationsList")
      val notificationsList: List<Notifications>,
      @SerializedName("password")
      val password: String,
      @SerializedName("profileImagePath")
      val profileImagePath: String,
      @SerializedName("role")
      val role: String,
      @SerializedName("salt")
      val salt: Salt,
      @SerializedName("token")
      val token: String,
      @SerializedName("userId")
      val userId: Int,
      @SerializedName("username")
      val username: String,
      @SerializedName("usersChallengesList")
      val usersChallengesList: List<Any>
    ) {
      data class BadgesUsers(
        @SerializedName("badge")
        val badge: Int,
        @SerializedName("badgeCount")
        val badgeCount: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("representBadge")
        val representBadge: Boolean,
        @SerializedName("user")
        val user: Int
      )

      data class Follower(
        @SerializedName("followId")
        val followId: Int
      )

      data class Following(
        @SerializedName("followId")
        val followId: Int
      )

      data class Notifications(
        @SerializedName("notificationContent")
        val notificationContent: String,
        @SerializedName("notificationId")
        val notificationId: Int,
        @SerializedName("notificationTitle")
        val notificationTitle: String
      )

      data class Salt(
        @SerializedName("id")
        val id: Int,
        @SerializedName("salt")
        val salt: String
      )
    }
  }
}
