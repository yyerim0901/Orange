package com.keelim.orange.domain

import com.keelim.orange.data.repository.friends.FriendsRepository
import com.keelim.orange.data.response.FriendsResponse
import com.keelim.orange.data.response.ResultResponse

class FriendsOkUseCase(
  private val friendsRepository: FriendsRepository
) {
  suspend fun invite(myId:String, uid:String): ResultResponse{
    return friendsRepository.sendInvite(myId, uid)
  }

  suspend fun getFriends(myId:String): FriendsResponse{
    return friendsRepository.getFriends(myId)
  }
}
