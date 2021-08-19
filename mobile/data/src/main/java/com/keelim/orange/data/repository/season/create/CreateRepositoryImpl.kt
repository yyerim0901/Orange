package com.keelim.orange.data.repository.season.create

import android.graphics.Bitmap
import com.keelim.orange.data.api.ApiRequestFactory
import com.keelim.orange.data.call.CreateCall
import com.keelim.orange.data.model.season.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.BufferedSink

class CreateRepositoryImpl(
  private val dispatcher: CoroutineDispatcher,
  private val apiRequestFactory: ApiRequestFactory
) : CreateRepository {
  private val replace = Article(
    "",
    -1,
    "",
    -1,
    "",
    -1,
    false,
    ""
  )

  override suspend fun upload(
    challengeId: Int,
    userId: Int,
    title: String,
    description: String,
  ): Article = withContext(dispatcher) {
    val response = apiRequestFactory.retrofit.upload(
      CreateCall(
        description,
        challengeId,
        title,
        userId,
        false
      )
    )
    if (response.isSuccessful) {
      return@withContext response.body()?.let {
        Article(
          articleContent = it.articleContent,
          articleId = it.articleId,
          articleWritetime = it.articleWritetime,
          challenge = it.challenge,
          title = it.title,
          user = it.user,
          verified = it.verified,
          articleImage = ""
        )
      } ?: replace
    } else {
      return@withContext replace
    }
  }

  override suspend fun image(articleId: Int, bitmap: Bitmap): Unit = withContext(dispatcher) {
    val bitmapRequestBody = BitmapRequestBody(bitmap)
    val bitmapMultipartBody =  MultipartBody.Part.createFormData("image", "article-$articleId", bitmapRequestBody)

    val articleRequestBody = articleId.toString().toPlainRequestBody()
    val hashMap = hashMapOf(
      "articleId" to articleRequestBody,
    )
    apiRequestFactory.retrofit.imageUpload(hashMap,bitmapMultipartBody)
  }

  inner class BitmapRequestBody(private val bitmap: Bitmap) : RequestBody() {
    override fun contentType(): MediaType = "image/jpeg".toMediaType()
    override fun writeTo(sink: BufferedSink) {
      bitmap.compress(Bitmap.CompressFormat.JPEG, 99, sink.outputStream())
    }
  }

  private fun String?.toPlainRequestBody() = requireNotNull(this).toRequestBody("text/plain".toMediaTypeOrNull())
}
