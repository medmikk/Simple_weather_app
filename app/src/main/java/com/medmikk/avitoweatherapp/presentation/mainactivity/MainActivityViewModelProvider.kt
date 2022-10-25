package com.medmikk.avitoweatherapp.presentation.mainactivity

import com.medmikk.avitoweatherapp.domain.usecase.GetForecastUsecase
import com.medmikk.avitoweatherapp.domain.usecase.GetGeoUsecase

class MainActivityViewModelProvider(
    private val getGeoUsecase: GetGeoUsecase,
    private val getForecastUsecase: GetForecastUsecase,

    ) {

}