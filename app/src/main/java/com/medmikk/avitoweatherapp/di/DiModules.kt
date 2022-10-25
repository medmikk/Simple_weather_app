package com.medmikk.avitoweatherapp.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.medmikk.avitoweatherapp.data.*
import com.medmikk.avitoweatherapp.data.remote.RetrofitClient
import com.medmikk.avitoweatherapp.data.remote.WeatherAPI
import com.medmikk.avitoweatherapp.domain.usecase.GetForecastUsecase
import com.medmikk.avitoweatherapp.domain.usecase.GetGeoUsecase
import com.medmikk.avitoweatherapp.presentation.mainactivity.MainActivityViewModel
import com.medmikk.avitoweatherapp.presentation.network.ConnectionChecker
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://api.openweathermap.org/"

val appModule = module {

    single<GeoRepository> { GeoRepositoryImpl(remoteDataSource = get()) }
    single<ForecastRepository> { ForecastRepositoryImpl(remoteDataSource = get()) }

    single<GetGeoUsecase> { GetGeoUsecaseImpl(repository = get()) }
    single<GetForecastUsecase> { GetForecastUsecaseImpl(repository = get()) }

}

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(
            getGeoUsecase = get(),
            getForecastUsecase = get(),
            connectionChecker = get()
        )
    }
}

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(RetrofitClient().createClient())
            .build().create(WeatherAPI::class.java)
    }
}


val networkObserverModule = module {
    single { ConnectionChecker(androidContext()) }
}

