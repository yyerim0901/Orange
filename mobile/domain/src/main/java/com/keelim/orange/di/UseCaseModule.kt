package com.keelim.orange.di

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.repository.LoginRepository
import com.keelim.orange.data.repository.NotificationRepository
import com.keelim.orange.data.repository.badge.BadgeRepository
import com.keelim.orange.data.repository.feed.FeedRepository
import com.keelim.orange.data.repository.friends.FriendsRepository
import com.keelim.orange.data.repository.history.HistoryRepository
import com.keelim.orange.data.repository.profile.ProfileRepository
import com.keelim.orange.data.repository.season.RankingRepository
import com.keelim.orange.data.repository.season.create.CreateRepository
import com.keelim.orange.data.repository.season.other.OtherRepository
import com.keelim.orange.domain.FriendsOkUseCase
import com.keelim.orange.domain.NotificationUseCase
import com.keelim.orange.domain.SendTokenServerUseCase
import com.keelim.orange.domain.auth.AuthUseCase
import com.keelim.orange.domain.auth.FavoriteUseCase
import com.keelim.orange.domain.badge.GetAllBadgeListUseCase
import com.keelim.orange.domain.badge.MyBadgeListUseCase
import com.keelim.orange.domain.feed.CategoryUseCase
import com.keelim.orange.domain.feed.ChallengeListUseCase
import com.keelim.orange.domain.feed.GetDetailInformationUseCase
import com.keelim.orange.domain.fight.CreateUseCase
import com.keelim.orange.domain.fight.OtherUseCase
import com.keelim.orange.domain.history.HistoryUseCase
import com.keelim.orange.domain.profile.GetCompletedChallengeUseCase
import com.keelim.orange.domain.profile.GetIngChallengeUseCase
import com.keelim.orange.domain.season.RankingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

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
  fun provideAuthUseCase(
    loginRepository: LoginRepository
  ): AuthUseCase {
    return AuthUseCase(loginRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideFavoriteUseCase(): FavoriteUseCase {
    return FavoriteUseCase()
  }

  @Provides
  @ViewModelScoped
  fun provideRankingUseCase(
    rankingRepository: RankingRepository
  ): RankingUseCase {
    return RankingUseCase(
      rankingRepository
    )
  }

  @Provides
  @ViewModelScoped
  fun provideOtherUseCase(
    otherRepository: OtherRepository,
  ): OtherUseCase {
    return OtherUseCase(
      otherRepository,
    )
  }

  @Provides
  @ViewModelScoped
  fun provideCreateUseCase(
    createRepository: CreateRepository,
  ): CreateUseCase {
    return CreateUseCase(
      createRepository,
    )
  }

  @Provides
  @ViewModelScoped
  fun provideGetDetailInformationUseCase(
    detailRepository: FeedRepository
  ): GetDetailInformationUseCase {
    return GetDetailInformationUseCase(
      detailRepository
    )
  }

  @Provides
  @ViewModelScoped
  fun provideFriendsUseCase(
    friendsRepository: FriendsRepository
  ): FriendsOkUseCase {
    return FriendsOkUseCase(
      friendsRepository
    )
  }

  @Provides
  @ViewModelScoped
  fun provideHistoryUseCase(
    historyRepository: HistoryRepository,
  ): HistoryUseCase{
    return HistoryUseCase(
      historyRepository
    )
  }
  @Provides
  @ViewModelScoped
  fun provideGetCompletedChallengeUseCase(
    profileRepository: ProfileRepository
  ): GetCompletedChallengeUseCase{
    return GetCompletedChallengeUseCase(
      profileRepository
    )
  }

  @Provides
  @ViewModelScoped
  fun provideGetIngChallengeUseCase(
    profileRepository:ProfileRepository
  ): GetIngChallengeUseCase{
    return GetIngChallengeUseCase(
      profileRepository
    )
  }

  @Provides
  @ViewModelScoped
  fun provideGetAllBadgeListUseCase(
    badgeRepository: BadgeRepository,
  ): GetAllBadgeListUseCase {
    return GetAllBadgeListUseCase(
      badgeRepository
    )
  }

  @Provides
  @ViewModelScoped
  fun provideMyBadgeListUseCase(
    badgeRepository: BadgeRepository,
  ): MyBadgeListUseCase {
    return MyBadgeListUseCase(
      badgeRepository
    )
  }

  @Provides
  @ViewModelScoped
  fun provideCategoryUseCase(
    feedRepository: FeedRepository
  ):CategoryUseCase{
    return CategoryUseCase(feedRepository)
  }

  @Provides
  @ViewModelScoped
  fun provideChallengeListUseCase(
    feedRepository: FeedRepository
  ): ChallengeListUseCase {
    return ChallengeListUseCase(feedRepository)
  }
}
