package com.medmikk.avitoweatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

class ForecastResponseDTO(
    @SerializedName("cod") var cod: String? = null,
    @SerializedName("message") var message: Int? = null,
    @SerializedName("cnt") var cnt: Int? = null,
    @SerializedName("list") var list: ArrayList<ForecastDTO> = arrayListOf(),
)