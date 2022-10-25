package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.domain.models.ForecastDomain
import com.medmikk.avitoweatherapp.domain.usecase.GetForecastUsecase

class GetForecastUsecaseImpl(private val repository: ForecastRepository) : GetForecastUsecase {
    override suspend fun getForecastData(
        isCashDataRequired: Boolean,
        lat: Double,
        lon: Double
    ): ForecastDomain {
        return if (isCashDataRequired) {
            repository.getCachedForecast(lat, lon)
        } else {
            repository.getRemoteForecast(lat, lon)
        }.also {
            //repository.saveToCach(it)
        }
    }
}