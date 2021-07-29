package com.keelim.orange.data.repository

import com.keelim.orange.data.model.Notification

interface NotificationRepository {
  suspend fun getAllNotificationList(): List<Notification>
}
