package com.keelim.orange.di

import com.keelim.orange.data.repository.NotificationRepository
import com.keelim.orange.data.repository.NotificationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    ):NotificationRepository{
        return NotificationRepositoryImpl(
            dispatcher,
        )
    }
}