package com.keelim.orange.data.repository

import com.keelim.orange.data.model.Notification
import com.keelim.orange.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NotificationRepositoryImpl @Inject constructor(
  @IoDispatcher private val dispatcher: CoroutineDispatcher
) : NotificationRepository {
  override suspend fun getAllNotificationList(): List<Notification> = withContext(dispatcher) {
    emptyList()
  }
}
