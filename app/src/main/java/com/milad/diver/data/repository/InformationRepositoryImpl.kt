package com.milad.diver.data.repository

import com.milad.diver.data.db.AppDatabase
import com.milad.diver.data.model.Information
import com.milad.diver.data.model.Transaction
import com.milad.diver.data.webservice.ApiInterface
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response

private const val HEADER =
    "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDE5NzEyNjgsInVzZXJfaWQiOjJ9.cSqUlrHqHu7teDlflMMc-ihRqsnpWszPdtlBemN0AlA"

 class InformationRepositoryImle(var apiInterface: ApiInterface, var appDatabase: AppDatabase):InformationRepository{

     override fun getInformationFromServer(): Single<Response<Information>> {

         return apiInterface.getInformation(HEADER)
     }

     override fun insertInformationToDB(information: Information): Completable {

         return appDatabase.informationDao().insertInfoIntoDB(information)
     }

     override fun insertTransactionListToDB(transactionList: List<Transaction>): Completable {

         return appDatabase.transactionDao().insertTransactionIntoDB(transactionList)
     }

     override fun getInformationFromDB(): Single<Information> {

         return appDatabase.informationDao().getInfoFromDB()
     }

     override fun getTransactionsFromDB(): Single<List<Transaction>> {
         return appDatabase.transactionDao().getTransactionFromDB()
     }
 }