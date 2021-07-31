package com.keelim.orange.di

import android.content.Context
import com.keelim.orange.data.datasource.LoginDataSource
import com.keelim.orange.data.repository.LoginRepository
import com.keelim.orange.data.repository.NotificationRepository
import com.keelim.orange.data.repository.NotificationRepositoryImpl
import com.keelim.orange.data.repository.season.RankingRepository
import com.keelim.orange.data.repository.theme.ThemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

  @Provides
  @Singleton
  fun provideNotificationRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
  ): NotificationRepository {
    return NotificationRepositoryImpl(
      dispatcher,
    )
  }

  @Provides
  @Singleton
  fun provideLoginRepository(
    dataSource: LoginDataSource
  ): LoginRepository {
    return LoginRepository(
      dataSource
    )
  }

  @Provides
  @Singleton
  fun provideThemeRepository(
    @ApplicationContext context: Context
  ): ThemeRepository {
    return ThemeRepository(
      context
    )
  }

  @Provides
  @Singleton
  fun provideRankingRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
  ): RankingRepository{
    return RankingRepository(dispatcher)
  }
}
