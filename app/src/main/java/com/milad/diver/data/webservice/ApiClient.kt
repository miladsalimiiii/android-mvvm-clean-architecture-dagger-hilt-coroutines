package com.milad.diver.data.webservice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        private var sRetrofit: Retrofit? = null
        private var sApiDolphin: ApiInterface? = null

        private fun getClient(
            okHttpClient: OkHttpClient.Builder, baseUrl: String
        ): Retrofit {

            if (sRetrofit == null) {

                sRetrofit = Retrofit.Builder().baseUrl(baseUrl)
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return sRetrofit!!
        }

        fun getService(
            okHttpClient: OkHttpClient.Builder,
            baseUrl: String
        ): ApiInterface? {

            if (sApiDolphin == null) {
                sApiDolphin = getClient(okHttpClient, baseUrl).create(
                    ApiInterface::class.java
                )
            }
            return sApiDolphin
        }
    }
}
