package com.medmikk.avitoweatherapp.domain.models

data class WeatherDomain(
    val temp: Double?,
    val details: String?,
    val ico: String?,
    val dateUnix: Int?
)