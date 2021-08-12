package com.keelim.orange.data.repository.season.other

interface OtherRepository {
  suspend fun sue(): Boolean
  suspend fun like(): Boolean
  suspend fun share(): Boolean
  suspend fun authenticate(): Boolean
}
