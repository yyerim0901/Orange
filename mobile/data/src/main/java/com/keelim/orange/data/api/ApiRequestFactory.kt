package com.keelim.orange.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import retrofit2.create

class ApiRequestFactory @Inject constructor() {
  private val baseUrl = "http://i5b102.p.ssafy.io:8181/"

  val retrofit:OrangeService = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .client(
      OkHttpClient.Builder().addInterceptor(
        HttpLoggingInterceptor().apply {
          this.level = HttpLoggingInterceptor.Level.BASIC
        }
      ).build()
    )
    .build()
    .create()
}
