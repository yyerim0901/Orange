package com.keelim.orange.ui.noti

import com.keelim.orange.data.model.Notification

sealed class NotificationState {
  object UnInitialized : NotificationState()
  object Loading : NotificationState()
  object Error : NotificationState()
  data class Success(
    val data: List<Notification>
  ) : NotificationState()
}
