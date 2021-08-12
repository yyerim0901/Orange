package com.keelim.orange.domain.profile

import com.keelim.orange.data.model.Favorite
import com.keelim.orange.data.repository.profile.ProfileRepository

class GetIngChallengeUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke():List<Favorite> {
        return profileRepository.getIngChallengeList()
    }
}