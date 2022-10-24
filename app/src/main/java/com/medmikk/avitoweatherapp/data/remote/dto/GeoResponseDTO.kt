package com.medmikk.avitoweatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GeoResponseDTO (
    @SerializedName("name"        ) var name       : String?     = null,
    @SerializedName("local_names" ) var localNames : LocalNamesDTO? = LocalNamesDTO(),
    @SerializedName("lat"         ) var lat        : Double?     = null,
    @SerializedName("lon"         ) var lon        : Double?     = null,
    @SerializedName("country"     ) var country    : String?     = null,
    @SerializedName("state"       ) var state      : String?     = null
)