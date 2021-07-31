package com.keelim.orange.di

import com.keelim.orange.data.repository.LoginRepository
import com.keelim.orange.data.repository.NotificationRepository
import com.keelim.orange.domain.FriendsOkUseCase
import com.keelim.orange.domain.NotificationUseCase
import com.keelim.orange.domain.SendTokenServerUseCase
import com.keelim.orange.domain.auth.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
  @Provides
  @ViewModelScoped
  fun provideNotificationUseCase(
    notificationRepository: NotificationRepository,
  ): NotificationUseCase {
    return NotificationUseCase(
      notificationRepository
    )
  }

  @Provides
  @ViewModelScoped
  fun provideSendTokenServerUseCase(): SendTokenServerUseCase {
    return SendTokenServerUseCase()
  }

  @Provides
  @ViewModelScoped
  fun provideFriendsOkUseCase(): FriendsOkUseCase {
    return FriendsOkUseCase()
  }

  @Provides
  @ViewModelScoped
  fun provideAuthUseCase(
    loginRepository:LoginRepository
  ): AuthUseCase{
    return AuthUseCase(
      loginRepository = loginRepository
    )
  }
}
