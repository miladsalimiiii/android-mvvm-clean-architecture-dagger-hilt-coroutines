package com.milad.diver.data.repository

import com.milad.diver.data.model.User
import retrofit2.Response

interface InformationRepository {

    suspend fun getInformationFromServer():Response<User>
}