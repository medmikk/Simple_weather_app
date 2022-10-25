package com.medmikk.avitoweatherapp.domain.usecase

import com.medmikk.avitoweatherapp.domain.models.GeoDomain

interface GetGeoUsecase {
    suspend fun getGeoData(isCashDataRequired: Boolean, cityName: String?): GeoDomain
}