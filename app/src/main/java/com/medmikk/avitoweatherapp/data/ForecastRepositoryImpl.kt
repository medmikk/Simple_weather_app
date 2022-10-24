package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.domain.models.ForecastDomain

class ForecastRepositoryImpl():ForecastRepository {
    override suspend fun getRemoteForecast(): ForecastDomain {
        TODO("Not yet implemented")
    }

    override suspend fun getCachedForecast(): ForecastDomain {
        TODO("Not yet implemented")
    }

    override suspend fun saveToCach(forecast: ForecastDomain) {
        TODO("Not yet implemented")
    }
}