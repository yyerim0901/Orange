package com.keelim.orange.data.repository.profile

import com.keelim.orange.data.model.Profile
import com.keelim.orange.data.model.entity.Favorite

interface ProfileRepository {
  suspend fun getIngChallengeList(): List<Favorite>
  suspend fun getCompletedChallengeList(): List<Favorite>
  suspend fun getProfileInformation(userId: Int): Profile
}
