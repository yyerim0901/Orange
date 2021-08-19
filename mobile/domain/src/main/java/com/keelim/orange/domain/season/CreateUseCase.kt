package com.keelim.orange.domain.season

import android.graphics.Bitmap
import com.keelim.orange.data.repository.season.create.CreateRepository

class CreateUseCase(
  private val createRepository: CreateRepository,
) {
  suspend fun upload(title: String, description: String, bitmap: Bitmap): Boolean {
    return createRepository.upload(title, description)
  }
}
