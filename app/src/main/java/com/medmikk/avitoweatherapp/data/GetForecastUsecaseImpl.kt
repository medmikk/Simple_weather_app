package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.domain.models.ForecastDomain
import com.medmikk.avitoweatherapp.domain.usecase.GetForecastUsecase

class GetForecastUsecaseImpl(private val repository: ForecastRepository): GetForecastUsecase {
    override suspend fun getForecastData(isCashDataRequired: Boolean): ForecastDomain {
        return if (isCashDataRequired) {
            repository.getCachedForecast()
        } else {
            repository.getRemoteForecast()
        }.also {
            repository.saveToCach(it)
        }
    }
}