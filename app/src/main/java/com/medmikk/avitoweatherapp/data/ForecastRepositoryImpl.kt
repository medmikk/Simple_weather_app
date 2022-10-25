package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.data.remote.ModelsMapper
import com.medmikk.avitoweatherapp.data.remote.WeatherAPI
import com.medmikk.avitoweatherapp.domain.models.ForecastDomain

class ForecastRepositoryImpl(
    private val remoteDataSource: WeatherAPI
) : ForecastRepository {

    override suspend fun getRemoteForecast(lat: Double, lon: Double): ForecastDomain {
        return ModelsMapper.mapRemoteForecastDTOToDomain(
            remoteDataSource.getForecastDataAsync(
                lon.toString(),
                lat.toString()
            ).await()
        )
    }

    override suspend fun getCachedForecast(lat: Double, lon: Double): ForecastDomain {
        TODO("Not yet implemented")
    }

    override suspend fun saveToCach(forecast: ForecastDomain) {
        TODO("Not yet implemented")
    }
}