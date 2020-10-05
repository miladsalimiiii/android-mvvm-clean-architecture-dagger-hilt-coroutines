package com.milad.diver.data.webservice

import com.milad.diver.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("2.2/users?order=desc&sort=reputation&site=stackoverflow")
    suspend fun getInformation(): Response<User>
}