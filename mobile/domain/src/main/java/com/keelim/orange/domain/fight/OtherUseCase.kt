package com.keelim.orange.domain.fight

import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.repository.season.other.OtherRepository
import com.keelim.orange.data.repository.season.other.OtherRepositoryImpl

class OtherUseCase(
    private val otherRepository: OtherRepository,
) {
    suspend fun authenticate(): Boolean {
        return otherRepository.authenticate()
    }

    suspend fun like(): Boolean {
        return otherRepository.like()
    }

    suspend fun sue(): Boolean {
        return otherRepository.sue()
    }

    suspend fun share(): Boolean {
        return otherRepository.share()
    }
}