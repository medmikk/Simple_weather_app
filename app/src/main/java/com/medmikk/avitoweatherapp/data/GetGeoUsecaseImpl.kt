package com.medmikk.avitoweatherapp.data

import com.medmikk.avitoweatherapp.domain.models.GeoDomain
import com.medmikk.avitoweatherapp.domain.usecase.GetGeoUsecase

class GetGeoUsecaseImpl(private val repository: GeoRepository) : GetGeoUsecase {
    override suspend fun getGeoData(isCashDataRequired: Boolean, cityName: String?): GeoDomain {
        return if (isCashDataRequired) {
            repository.getCashedGeo()
        } else {
            return repository.getRemoteGeo(cityName!!)
        }.also {
            repository.saveToCash(it)
        }
    }
}