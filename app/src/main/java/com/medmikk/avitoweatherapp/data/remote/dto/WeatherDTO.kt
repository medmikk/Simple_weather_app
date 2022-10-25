package com.medmikk.avitoweatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

class WeatherDTO(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("main") var main: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("icon") var icon: String? = null
)