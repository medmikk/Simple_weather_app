package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.domain.models.ForecastDomain

interface ForecastRepository {
    suspend fun getRemoteForecast(lat: Double, lon: Double): ForecastDomain
    suspend fun getCachedForecast(lat: Double, lon: Double): ForecastDomain
    suspend fun saveToCach(forecast: ForecastDomain)
}