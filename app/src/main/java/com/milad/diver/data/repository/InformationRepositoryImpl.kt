package com.milad.diver.data.repository


import com.milad.diver.data.model.Information
import com.milad.diver.data.webservice.ApiInterface
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

private const val HEADER =
    "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDE5NzEyNjgsInVzZXJfaWQiOjJ9.cSqUlrHqHu7teDlflMMc-ihRqsnpWszPdtlBemN0AlA"

 class InformationRepositoryImle @Inject constructor(var apiInterface: ApiInterface):InformationRepository{

     override fun getInformationFromServer(): Single<Response<Array<Information>>> {

         return apiInterface.getInformation()
     }

//     override fun insertInformationToDB(information: Information): Completable {
//
//         return appDatabase.informationDao().insertInfoIntoDB(information)
//     }
//
//     override fun insertTransactionListToDB(transactionList: List<Transaction>): Completable {
//
//         return appDatabase.transactionDao().insertTransactionIntoDB(transactionList)
//     }
//
//     override fun getInformationFromDB(): Single<Information> {
//
//         return appDatabase.informationDao().getInfoFromDB()
//     }
//
//     override fun getTransactionsFromDB(): Single<List<Transaction>> {
//         return appDatabase.transactionDao().getTransactionFromDB()
//     }
 }