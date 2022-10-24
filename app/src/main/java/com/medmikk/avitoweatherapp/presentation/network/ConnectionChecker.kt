package com.medmikk.avitoweatherapp.presentation.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class ConnectionChecker(context: Context) {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    fun checkIsNetworkAvailable(): Boolean {
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when{
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {true}
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {true}
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {true}
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> {true}
            else -> false
        }
    }

}