package com.keelim.orange.domain.feed

import com.keelim.orange.data.response.feed.CategoryResponse
import com.keelim.orange.data.repository.feed.FeedRepository

class CategoryUseCase(
  private val feedRepository: FeedRepository,
) {
  suspend operator fun invoke(): List<CategoryResponse> {
    return feedRepository.getCategory()
  }
}
