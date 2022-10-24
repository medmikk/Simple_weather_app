package com.medmikk.avitoweatherapp.data.remote

import androidx.viewbinding.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class RetrofitClient {
    fun createClient(): OkHttpClient{
        val client = OkHttpClient.Builder()
            .addInterceptor(RetrofitInterceptor())

        if (BuildConfig.DEBUG) {
            client.addInterceptor(HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return client.build()
    }
}