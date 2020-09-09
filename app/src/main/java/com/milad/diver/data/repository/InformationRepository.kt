package com.milad.diver.data.repository

import com.milad.diver.data.model.Information
import io.reactivex.Single
import retrofit2.Response

interface InformationRepository {

    fun getInformationFromServer():Single<Response<Array<Information>>>
//    fun insertInformationToDB(information: Information):Completable
//    fun insertTransactionListToDB(transactionList:List<Transaction>):Completable
//    fun getInformationFromDB():Single<Information>
//    fun getTransactionsFromDB():Single<List<Transaction>>

}