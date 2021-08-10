package com.keelim.orange.di

import android.content.Context
import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.datasource.LoginDataSource
import com.keelim.orange.data.db.AppDatabase
import com.keelim.orange.data.repository.LoginRepository
import com.keelim.orange.data.repository.NotificationRepository
import com.keelim.orange.data.repository.NotificationRepositoryImpl
import com.keelim.orange.data.repository.badge.BadgeRepository
import com.keelim.orange.data.repository.badge.BadgeRepositoryImpl
import com.keelim.orange.data.repository.feed.detail.DetailRepository
import com.keelim.orange.data.repository.feed.detail.DetailRepositoryImpl
import com.keelim.orange.data.repository.friends.FriendsRepository
import com.keelim.orange.data.repository.friends.FriendsRepositoryImpl
import com.keelim.orange.data.repository.history.HistoryRepository
import com.keelim.orange.data.repository.history.HistoryRepositoryImpl
import com.keelim.orange.data.repository.profile.ProfileRepository
import com.keelim.orange.data.repository.profile.ProfileRepositoryImpl
import com.keelim.orange.data.repository.season.RankingRepository
import com.keelim.orange.data.repository.season.create.CreateRepository
import com.keelim.orange.data.repository.season.create.CreateRepositoryImpl
import com.keelim.orange.data.repository.season.other.OtherRepository
import com.keelim.orange.data.repository.season.other.OtherRepositoryImpl
import com.keelim.orange.data.repository.theme.ThemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher

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
  ): RankingRepository {
    return RankingRepository(dispatcher)
  }

  @Provides
  @Singleton
  fun provideOtherRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    apiRequestFactory: ApiRequestFactory,
  ): OtherRepository {
    return OtherRepositoryImpl(
      dispatcher,
      apiRequestFactory,
    )
  }

  @Provides
  @Singleton
  fun provideCreateRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    apiRequestFactory: ApiRequestFactory,
  ): CreateRepository {
    return CreateRepositoryImpl(
      dispatcher,
      apiRequestFactory
    )
  }

  @Provides
  @Singleton
  fun provideDetailRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    apiRequestFactory: ApiRequestFactory,
  ): DetailRepository {
    return DetailRepositoryImpl(
      apiRequestFactory,
      dispatcher
    )
  }

  @Provides
  @Singleton
  fun provideFriendsRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    apiRequestFactory: ApiRequestFactory,
  ): FriendsRepository {
    return FriendsRepositoryImpl(
      dispatcher,
      apiRequestFactory
    )
  }

  @Provides
  @Singleton
  fun provideHistoryRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    db: AppDatabase,
  ): HistoryRepository {
    return HistoryRepositoryImpl(
      dispatcher,
      db
    )
  }

  @Provides
  @Singleton
  fun provideProfileRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    apiRequestFactory: ApiRequestFactory,
  ): ProfileRepository{
    return ProfileRepositoryImpl(
      dispatcher = dispatcher,
      apiRequestFactory = apiRequestFactory
    )
  }

  @Provides
  @Singleton
  fun provideBadgeRepository(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    apiRequestFactory: ApiRequestFactory,
  ): BadgeRepository{
    return BadgeRepositoryImpl(
      dispatcher = dispatcher,
      apiRequestFactory = apiRequestFactory
    )
  }
}
