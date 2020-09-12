package com.milad.diver.data.webservice

import com.milad.diver.data.model.Information
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("reports")
    fun getInformation(): Single<Response<Array<Information>>>
}