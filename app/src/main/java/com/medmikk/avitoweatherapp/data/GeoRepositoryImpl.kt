package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.data.remote.ModelsMapper
import com.medmikk.avitoweatherapp.data.remote.WeatherAPI
import com.medmikk.avitoweatherapp.domain.models.GeoDomain
import kotlinx.coroutines.Deferred

class GeoRepositoryImpl (
    private val remoteDataSource: WeatherAPI,
): GeoRepository {

    override suspend fun getCashedGeo(): GeoDomain {
        TODO("Not yet implemented")
    }

    override suspend fun getRemoteGeo(city: String): GeoDomain {
        return ModelsMapper.mapRemoteGeoDTOToDomain(remoteDataSource.getGeoDataAsync(city).await()[0])
    }

    override suspend fun saveToCash(geo: GeoDomain) {
        TODO("Not yet implemented")
    }

}