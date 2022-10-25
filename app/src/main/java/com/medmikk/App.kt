package com.medmikk

import android.app.Application
import com.medmikk.avitoweatherapp.di.appModule
import com.medmikk.avitoweatherapp.di.networkObserverModule
import com.medmikk.avitoweatherapp.di.retrofitModule
import com.medmikk.avitoweatherapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                appModule,
                viewModelModule,
                retrofitModule,
                networkObserverModule
            )
        }
    }
}