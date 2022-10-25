package com.medmikk.avitoweatherapp.data.remote

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

private const val APP_ID_PARAM_NAME = "appid"
private const val APP_ID_PARAM_VALUE = "ced1835a898fcca9ab2869d76a521469"

class RetrofitInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val updatedUrl = chain.request().url.newBuilder()
            .addQueryParameter(APP_ID_PARAM_NAME, APP_ID_PARAM_VALUE)
            .build()

        Log.d("URL", updatedUrl.toString())
        return chain.proceed(
            chain.request().newBuilder()
                .url(updatedUrl)
                .build()
        )
    }
}