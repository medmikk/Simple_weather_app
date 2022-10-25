package com.medmikk.avitoweatherapp.domain.usecase

import com.medmikk.avitoweatherapp.domain.models.ForecastDomain

interface GetForecastUsecase {
    suspend fun getForecastData(
        isCashDataRequired: Boolean,
        lat: Double,
        lon: Double
    ): ForecastDomain
}