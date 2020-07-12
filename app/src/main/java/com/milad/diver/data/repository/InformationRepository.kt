package com.milad.diver.data.repository

import com.milad.diver.data.webservice.ApiInterface
import com.milad.diver.ui.base.BaseRepository

private const val HEADER="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDE5NzEyNjgsInVzZXJfaWQiOjJ9.cSqUlrHqHu7teDlflMMc-ihRqsnpWszPdtlBemN0AlA"

class InformationRepository(var apiInterface: ApiInterface) :BaseRepository(){

    fun getTransactions()=apiInterface.getInformation(HEADER)
    val x=1

}