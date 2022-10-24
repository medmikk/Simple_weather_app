package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.domain.models.ForecastDomain

interface ForecastRepository {
    suspend fun getRemoteForecast(): ForecastDomain
    suspend fun getCachedForecast(): ForecastDomain
    suspend fun saveToCach(forecast: ForecastDomain)
}