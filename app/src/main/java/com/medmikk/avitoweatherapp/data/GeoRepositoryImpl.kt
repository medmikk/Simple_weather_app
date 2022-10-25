package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.data.remote.ModelsMapper
import com.medmikk.avitoweatherapp.data.remote.WeatherAPI
import com.medmikk.avitoweatherapp.domain.models.GeoDomain

class GeoRepositoryImpl(
    private val remoteDataSource: WeatherAPI
) : GeoRepository {

    override suspend fun getCashedGeo(): GeoDomain {
        return GeoDomain(null, null, null)
        //TODO implement
    }

    override suspend fun getRemoteGeo(city: String): GeoDomain {
        val response = remoteDataSource.getGeoDataAsync(city).await()
        if (response.isEmpty())
            return GeoDomain(null, null, null)
        if (response[0].cod != 200 && response[0].cod != null)
            return GeoDomain(null, null, null)
        return ModelsMapper.mapRemoteGeoDTOToDomain(response[0])
    }

    override suspend fun saveToCash(geo: GeoDomain) {
        //TODO("Not yet implemented")
    }

}