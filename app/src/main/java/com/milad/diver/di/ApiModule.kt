package com.milad.diver.di

import com.milad.diver.data.webservice.ApiClient
import okhttp3.OkHttpClient
import org.koin.dsl.module

private const val BASE_URL="http://api-develop.diver.ir/app/user/"

val apiModule= module {

    single {
        ApiClient.getService(okHttpClient = get(),
            baseUrl = get())
    }
    single() { BASE_URL }
    factory () { OkHttpClient().newBuilder()}

}