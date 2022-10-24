package com.medmikk.avitoweatherapp.data.remote

import com.medmikk.avitoweatherapp.data.remote.dto.ForecastResponseDTO
import com.medmikk.avitoweatherapp.data.remote.dto.GeoResponseDTO
import com.medmikk.avitoweatherapp.domain.models.ForecastDomain
import com.medmikk.avitoweatherapp.domain.models.GeoDomain
import com.medmikk.avitoweatherapp.domain.models.WeatherDomain

object ModelsMapper {
    fun mapRemoteForecastDTOToDomain(forecastResponseDTO: ForecastResponseDTO): ForecastDomain{
        var list = ArrayList<WeatherDomain>()
        for (weather in forecastResponseDTO.list)
            list.add(
                WeatherDomain(
                temp = weather.main?.temp,
                details = weather.weather[0].description,
                ico = null, //TODO make icons
                dateUnix = weather.dt
            )
            )
        return ForecastDomain(forecast = list)
    }

    suspend fun mapRemoteGeoDTOToDomain(geoResponseDTO: GeoResponseDTO): GeoDomain{
        return with(geoResponseDTO){
            GeoDomain(
                lat = lat,
                lon = lon,
                name = name
            )
        }
    }
}