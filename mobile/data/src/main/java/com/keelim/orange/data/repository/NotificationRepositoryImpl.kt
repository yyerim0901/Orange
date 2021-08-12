package com.keelim.orange.data.repository

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.model.notification.Notification
import com.keelim.orange.di.IoDispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class NotificationRepositoryImpl @Inject constructor(
  @IoDispatcher private val dispatcher: CoroutineDispatcher,
  private val apiRequestFactory: ApiRequestFactory,
) : NotificationRepository {
  override suspend fun getAllNotificationList(userId: Int): List<Notification> =
    withContext(dispatcher) {
      val response = apiRequestFactory.retrofit.getNotificationList(
        userId = userId
      )
      if (response.isSuccessful) {
        return@withContext response.body()?.map {
          it.responseToNotification()
        } ?: listOf()
      } else {
        return@withContext listOf()
      }
    }
}
