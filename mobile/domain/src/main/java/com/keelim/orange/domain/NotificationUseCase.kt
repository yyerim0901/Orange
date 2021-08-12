package com.keelim.orange.domain

import com.keelim.orange.data.model.notification.Notification
import com.keelim.orange.data.repository.NotificationRepository
import javax.inject.Inject

class NotificationUseCase @Inject constructor(
  private val notificationRepository: NotificationRepository,
) {
  suspend operator fun invoke(userId:Int): List<Notification> {
    return notificationRepository.getAllNotificationList(userId)
  }
}
