package com.milad.diver.ui.transactions

import androidx.lifecycle.MutableLiveData
import com.milad.diver.data.model.Information
import com.milad.diver.data.model.common.MyResponse
import com.milad.diver.data.repository.InformationRepositoryImle
import com.milad.diver.ui.base.BaseViewModel
import com.milad.diver.ui.util.UtilInternetConnection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TransactionViewModel(
    var informationRepository: InformationRepositoryImle,
    var utilInternetConnection: UtilInternetConnection
) : BaseViewModel() {

    var mGetInformationLiveData = MutableLiveData<MyResponse<Array<Information>>>()

    fun getTransactions() {

       // if (utilInternetConnection.isInternetAvailable()) {
            val disposable = informationRepository.getInformationFromServer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    when (response.code()) {
                        200 -> {
                           // response.body()?.let { insertInformationIntoDB(it) }
                            mGetInformationLiveData.value = MyResponse.success(response.body()!!)
                        }
                    }
                }, {
                    mGetInformationLiveData.value = MyResponse.failed(it)
                })
            mCompositeDisposable.add(disposable)
     //   } else {
//            val disposable = informationRepository.getInformationFromDB()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                   // getTransactionFromDB(it)
//                }, {
//
//                })
//            mCompositeDisposable.add(disposable)
        }
   // }

//    private fun insertInformationIntoDB(information: Information) {
//        val disposable = informationRepository.insertInformationToDB(information)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                insertTransactionIntoDB(information)
//            }, {
//                mGetInformationLiveData.value = MyResponse.failed(it)
//            })
//        mCompositeDisposable.add(disposable)
//    }

//    private fun insertTransactionIntoDB(information: Information) {
//        val disposable = information.mTransactions?.let {
//            informationRepository.insertTransactionListToDB(it)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    mGetInformationLiveData.value = MyResponse.success(information)
//                }, {
//                    mGetInformationLiveData.value = MyResponse.failed(it)
//                })
//        }
//        disposable?.let { mCompositeDisposable.add(it) }
//    }

//    private fun getTransactionFromDB(information: Information) {
//        val disposable = informationRepository.getTransactionsFromDB()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                information.mTransactions = it
//                mGetInformationLiveData.value = MyResponse.success(information)
//            }, {
//
//            })
//        mCompositeDisposable.add(disposable)
//    }

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.clear()
    }
}