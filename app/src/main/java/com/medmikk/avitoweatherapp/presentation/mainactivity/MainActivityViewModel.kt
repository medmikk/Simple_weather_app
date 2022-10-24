package com.medmikk.avitoweatherapp.presentation.mainactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medmikk.avitoweatherapp.domain.models.GeoDomain
import com.medmikk.avitoweatherapp.domain.usecase.GetForecastUsecase
import com.medmikk.avitoweatherapp.domain.usecase.GetGeoUsecase
import com.medmikk.avitoweatherapp.presentation.network.ConnectionChecker
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val getGeoUsecase: GetGeoUsecase,
    private val getForecastUsecase: GetForecastUsecase,
    private val connectionChecker: ConnectionChecker
):ViewModel() {

    private val geo : MutableLiveData<Pair<Double?, Double?>> = MutableLiveData()
    val geoPublic = geo

    init {
        //getForecastData(getCurrentGeo())
    }

    fun getCurrentGeo(){

    }

    fun getGeoData(cityName: String?) = viewModelScope.launch{
        val response = getGeoUsecase.getGeoData(!connectionChecker.checkIsNetworkAvailable(), cityName)
        geo.value = Pair(response.lat, response.lon)
    }

}