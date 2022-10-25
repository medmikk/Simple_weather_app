package com.medmikk.avitoweatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

class ForecastDTO(
    @SerializedName("dt") var dt: Int? = null,
    @SerializedName("main") var main: TemperatureDTO? = TemperatureDTO(),
    @SerializedName("weather") var weather: ArrayList<WeatherDTO> = arrayListOf(),
)