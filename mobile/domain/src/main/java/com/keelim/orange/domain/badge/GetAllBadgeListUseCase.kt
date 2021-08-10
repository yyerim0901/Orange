package com.keelim.orange.domain.badge

import com.keelim.orange.data.model.Badge
import com.keelim.orange.data.repository.badge.BadgeRepository
import timber.log.Timber

class GetAllBadgeListUseCase(
    private val badgeRepository: BadgeRepository
) {
    suspend  operator fun invoke():List<Badge>{
        Timber.d("[retrofit] version1")
        return badgeRepository.getAllBadge()
    }
}