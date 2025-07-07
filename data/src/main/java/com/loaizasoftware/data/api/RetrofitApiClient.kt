package com.loaizasoftware.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApiClient {

    private val base_url = "https://backend-usershandlerapp.fly.dev/usershandlerapp/api/"
    var apiService: RetrofitApiService

    init {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        // Create and configure the logging interceptor
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC // Logs request and response lines and their respective headers and bodies (if present)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS) // Connection timeout
            .readTimeout(30, TimeUnit.SECONDS)    // Read timeout
            .writeTimeout(30, TimeUnit.SECONDS)   // Write timeout
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(base_url)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(RetrofitApiService::class.java)

    }

}