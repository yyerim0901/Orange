package com.keelim.orange.domain.fight

import com.keelim.orange.data.repository.season.create.CreateRepository

class CreateUseCase(
  private val createRepository: CreateRepository,
) {
  suspend fun upload(title: String, description: String): Boolean {
    return createRepository.upload(title, description)
  }
}
