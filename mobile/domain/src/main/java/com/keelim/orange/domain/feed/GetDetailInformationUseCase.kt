package com.keelim.orange.domain.feed

import com.keelim.orange.data.repository.feed.detail.DetailRepository
import com.keelim.orange.data.response.DetailResponse

class GetDetailInformationUseCase(
    private val detailRepository: DetailRepository
) {
    suspend operator fun invoke(uid:String): DetailResponse {
        return detailRepository.getDetail(uid)
    }
}