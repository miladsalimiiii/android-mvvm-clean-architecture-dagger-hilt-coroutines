package com.milad.diver.data.repository

import com.milad.diver.data.model.Information
import com.milad.diver.data.model.Transaction
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response

interface InformationRepository {

    fun getInformationFromServer():Single<Response<Information>>
    fun insertInformationToDB(information: Information):Completable
    fun insertTransactionListToDB(transactionList:List<Transaction>):Completable
    fun getInformationFromDB():Single<Information>
    fun getTransactionsFromDB():Single<List<Transaction>>

}