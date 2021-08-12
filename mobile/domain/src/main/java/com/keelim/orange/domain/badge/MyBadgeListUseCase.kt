package com.keelim.orange.domain.badge

import com.keelim.orange.data.model.Badge
import com.keelim.orange.data.repository.badge.BadgeRepository
import timber.log.Timber

class MyBadgeListUseCase(
    private val badgeRepository: BadgeRepository
) {
    suspend  operator fun invoke(userId:Int):List<Badge>{
        return badgeRepository.getMyBadge(userId)
    }
}