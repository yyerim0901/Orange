package com.keelim.orange.data.response.notification


import com.google.gson.annotations.SerializedName
import com.keelim.orange.data.model.notification.Notification
import com.keelim.orange.data.model.notification.NotificationType

data class NotificationResponse(
  @SerializedName("notificationContent")
  val notificationContent: String,
  @SerializedName("notificationId")
  val notificationId: Int,
  @SerializedName("notificationTitle")
  val notificationTitle: String,
  @SerializedName("user")
  val user: User
) {
  fun responseToNotification() = Notification(
    title =notificationTitle,
    description = notificationContent,
    type = NotificationType.NOTIFICATION_BASIC,
  )
  data class User(
    @SerializedName("articlesList")
    val articlesList: List<Any>,
    @SerializedName("badgesUsersList")
    val badgesUsersList: List<Any>,
    @SerializedName("commentsList")
    val commentsList: List<Any>,
    @SerializedName("email")
    val email: String,
    @SerializedName("followerList")
    val followerList: List<Any>,
    @SerializedName("followingList")
    val followingList: List<Any>,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("notificationsList")
    val notificationsList: List<Int>,
    @SerializedName("password")
    val password: String,
    @SerializedName("profileImagePath")
    val profileImagePath: Any,
    @SerializedName("role")
    val role: Any,
    @SerializedName("salt")
    val salt: Salt,
    @SerializedName("token")
    val token: Any,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("usersChallengesList")
    val usersChallengesList: List<UsersChallenges>
  ) {
    data class Salt(
      @SerializedName("id")
      val id: Int,
      @SerializedName("salt")
      val salt: String
    )

    data class UsersChallenges(
      @SerializedName("challenge")
      val challenge: Challenge,
      @SerializedName("id")
      val id: Int,
      @SerializedName("manager")
      val manager: Boolean,
      @SerializedName("point")
      val point: Int,
      @SerializedName("user")
      val user: Int
    ) {
      data class Challenge(
        @SerializedName("articlesList")
        val articlesList: List<Any>,
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
        val usersChallengesList: List<Int>
      )
    }
  }
}