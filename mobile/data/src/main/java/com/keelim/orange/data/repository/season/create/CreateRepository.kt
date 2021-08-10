package com.keelim.orange.data.repository.season.create

interface CreateRepository {
  suspend fun upload(title: String, description: String): Boolean
}
