package com.keelim.orange.domain.feed

import com.keelim.orange.data.model.Search2
import com.keelim.orange.data.repository.feed.FeedRepository
import com.keelim.orange.data.response.DetailResponse

class GetDetailInformationUseCase(
  private val detailRepository: FeedRepository
) {
  suspend operator fun invoke(uid: Int): Search2? {
    return detailRepository.getDetail(uid)
  }
}
