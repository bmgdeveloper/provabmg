package com.picpay.desafio.android.di

import com.google.gson.GsonBuilder
import com.picpay.desafio.android.service.PicPayService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

val networkModule = module {
    factory { provideUserApi(get()) }
    single { provideConfigRetrofit() }
}

    fun provideConfigRetrofit(): Retrofit =  Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .client( OkHttpClient.Builder().build())
        .build()

    fun provideUserApi(retrofit: Retrofit): PicPayService = retrofit.create(PicPayService::class.java)


