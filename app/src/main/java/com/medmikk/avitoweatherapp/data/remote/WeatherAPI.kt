package com.medmikk.avitoweatherapp.data.remote

import com.medmikk.avitoweatherapp.data.remote.dto.ForecastResponseDTO
import com.medmikk.avitoweatherapp.data.remote.dto.GeoResponseDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("geo/1.0/direct?")
    fun getGeoDataAsync(
        @Query("q") q: String
    ): Deferred<List<GeoResponseDTO>>

    @GET("data/2.5/forecast?")
    fun getForecastDataAsync(
        @Query("lon") lon: String,
        @Query("lat") lat: String
    ): Deferred<ForecastResponseDTO>
}