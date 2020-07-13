package com.milad.diver.ui.transactions

import androidx.lifecycle.MutableLiveData
import com.milad.diver.data.model.Information
import com.milad.diver.data.model.common.MyResponse
import com.milad.diver.data.repository.InformationRepository
import com.milad.diver.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TransactionViewModel(var informationRepository: InformationRepository) : BaseViewModel() {

     var mGetInformationLiveData=MutableLiveData<MyResponse<Information>>()


    fun getTransactions(){

        val disposable=informationRepository.getTransactions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response->

                when(response.code()){
                    200->{mGetInformationLiveData.value= response.body()?.let { information ->
                        MyResponse.success(
                            information
                        )
                    }
                    }
                }

            },{

                val x=1

            })
        mCompositeDisposable.add(disposable)
    }
}