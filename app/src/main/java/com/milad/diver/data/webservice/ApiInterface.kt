package com.milad.diver.data.webservice

import com.milad.diver.data.model.Information
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {
    @GET("home?last_get_time=20200102000000")
    fun getInformation(@Header("Authorization") header: String): Single<Response<Information>>
}