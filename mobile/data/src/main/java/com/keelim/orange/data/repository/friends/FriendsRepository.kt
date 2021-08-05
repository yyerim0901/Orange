package com.keelim.orange.data.repository.friends

import com.keelim.orange.data.response.FriendsResponse
import com.keelim.orange.data.response.ResultResponse

interface FriendsRepository {
    suspend fun sendInvite(myId: String, uid: String): ResultResponse
    suspend fun getFriends(myId:String): FriendsResponse
}