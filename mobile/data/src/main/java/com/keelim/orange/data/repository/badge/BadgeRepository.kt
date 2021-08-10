package com.keelim.orange.data.repository.badge

import com.keelim.orange.data.model.Badge

interface BadgeRepository {
    suspend fun getAllBadge(): List<Badge>
}