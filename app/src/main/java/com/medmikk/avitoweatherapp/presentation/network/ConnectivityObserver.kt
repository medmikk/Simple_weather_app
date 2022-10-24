package com.medmikk.avitoweatherapp.presentation.network

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun checkIsNetworkAvailable(): Boolean
    fun observe(): Flow<NetworkConnectionStatus>
}