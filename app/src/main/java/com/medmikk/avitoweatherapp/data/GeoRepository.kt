package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.domain.models.GeoDomain

interface GeoRepository {
    suspend fun getRemoteGeo(city: String): GeoDomain
    suspend fun getCashedGeo(): GeoDomain
    suspend fun saveToCash(geo: GeoDomain)
}