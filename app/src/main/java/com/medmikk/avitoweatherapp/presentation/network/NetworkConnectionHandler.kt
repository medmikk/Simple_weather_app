package com.medmikk.avitoweatherapp.presentation.network

import android.app.Activity
import android.app.AlertDialog

class NetworkConnectionHandler : ConnectionHandler {
    override fun handleInternetConnectionStatus(
        activity: Activity,
        status: NetworkConnectionStatus
    ) {
        if (status != NetworkConnectionStatus.AVAILABLE){
            showNoConnectionAlert(activity)
        }
    }

    override fun showNoConnectionAlert(activity: Activity) {
//TODO make alert
        AlertDialog.Builder(activity).apply {
            setTitle("Интернет отсутствует")
            setMessage("Отображены последние сохраненные данные")
            create()
            show()
        }

    }
}