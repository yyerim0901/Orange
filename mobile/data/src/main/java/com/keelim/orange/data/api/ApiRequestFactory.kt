package com.keelim.orange.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiRequestFactory @Inject constructor() {
  private val baseUrl = ""

  val retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .client(
      OkHttpClient.Builder().addInterceptor(
        HttpLoggingInterceptor().apply {
          this.level = HttpLoggingInterceptor.Level.BODY
        }
      ).build()
    )
    .build()
    .create(OrangeService::class.java)
}
