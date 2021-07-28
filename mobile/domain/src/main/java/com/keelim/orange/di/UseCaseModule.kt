package com.keelim.orange.di

import com.keelim.orange.data.repository.NotificationRepository
import com.keelim.orange.domain.NotificationUseCase
import com.keelim.orange.domain.SendTokenServerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
  @Provides
  @Singleton
  fun provideNotificationUseCase(
    notificationRepository: NotificationRepository,
  ): NotificationUseCase {
    return NotificationUseCase(
      notificationRepository
    )
  }

  @Provides
  @Singleton
  fun provideSendTokenServerUseCase(): SendTokenServerUseCase {
    return SendTokenServerUseCase()
  }
}
