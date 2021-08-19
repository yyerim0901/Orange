package com.keelim.orange.data.repository.season.create

import android.graphics.Bitmap
import com.keelim.orange.data.model.season.Article

interface CreateRepository {
  suspend fun upload(challengeId: Int, userId: Int, title: String, description: String): Article
  suspend fun image(articleId:Int, bitmap: Bitmap)
}
