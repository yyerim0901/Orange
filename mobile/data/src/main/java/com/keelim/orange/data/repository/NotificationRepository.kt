package com.keelim.orange.data.repository

import com.keelim.orange.data.model.notification.Notification

interface NotificationRepository {
  suspend fun getAllNotificationList(userId:Int): List<Notification>
}
