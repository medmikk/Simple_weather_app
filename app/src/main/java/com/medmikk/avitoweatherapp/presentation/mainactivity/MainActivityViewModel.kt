package com.medmikk.avitoweatherapp.presentation.mainactivity


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medmikk.avitoweatherapp.domain.models.WeatherDomain
import com.medmikk.avitoweatherapp.domain.usecase.GetForecastUsecase
import com.medmikk.avitoweatherapp.domain.usecase.GetGeoUsecase
import com.medmikk.avitoweatherapp.presentation.network.ConnectionChecker
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val getGeoUsecase: GetGeoUsecase,
    private val getForecastUsecase: GetForecastUsecase,
    private val connectionChecker: ConnectionChecker
) : ViewModel() {

    private val forecast: MutableLiveData<List<WeatherDomain>> = MutableLiveData()
    val forecastPublic = forecast

    private val toastCondition: MutableLiveData<Boolean> = MutableLiveData(false)
    val toastConditionPublic = toastCondition

    private val geo: MutableLiveData<Pair<Double?, Double?>> = MutableLiveData()

    init {
        getForecastForCity("moscow")
    }

    fun getForecastForCity(cityName: String?) = viewModelScope.launch {
        val response =
            getGeoUsecase.getGeoData(!connectionChecker.checkIsNetworkAvailable(), cityName)
        if (response.lat == null || response.lon == null) {
            toastCondition.value = true
        } else {
            geo.value = Pair(response.lat, response.lon)

            val fresponse = getForecastUsecase.getForecastData(
                !connectionChecker.checkIsNetworkAvailable(),
                response.lat,
                response.lon
            )
            forecast.value = fresponse.forecast
        }
    }

    fun toastComplete() {
        toastCondition.value = false
    }

}