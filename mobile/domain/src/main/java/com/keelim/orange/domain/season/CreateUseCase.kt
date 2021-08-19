package com.keelim.orange.domain.season

import android.graphics.Bitmap
import com.keelim.orange.data.repository.season.create.CreateRepository
import timber.log.Timber

class CreateUseCase(
  private val createRepository: CreateRepository,
) {
  suspend fun upload(
    challengeId: Int,
    userId: Int,
    title: String,
    description: String,
    bitmap: Bitmap,
  ) {
    //1.
    try {
      val article = createRepository.upload(challengeId, userId, title, description)

      val imageUpload = createRepository.image(article.articleId, bitmap)
    } catch (e:Exception){
      Timber.e("[what the] $e")
    }
  }
}
