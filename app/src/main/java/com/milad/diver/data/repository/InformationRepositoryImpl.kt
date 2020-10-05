package com.milad.diver.data.repository


import com.milad.diver.data.model.User
import com.milad.diver.data.webservice.ApiInterface
import retrofit2.Response
import javax.inject.Inject


class InformationRepositoryImle @Inject constructor(var apiInterface: ApiInterface):InformationRepository{

     override suspend fun getInformationFromServer(): Response<User> {

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