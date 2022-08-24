package com.milad.diver.ui.transactions

import androidx.lifecycle.MutableLiveData
import com.milad.diver.data.model.User
import com.milad.diver.data.model.common.MyResponse
import com.milad.diver.data.repository.InformationRepositoryImle
import com.milad.diver.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
   private var informationRepository: InformationRepositoryImle
) : BaseViewModel() , CoroutineScope by MainScope(){

    var mGetInformationLiveData = MutableLiveData<MyResponse<User>>()

    fun getTransactions() {
        launch(Dispatchers.Main) {
            val response = runCatching { informationRepository.getInformationFromServer() }
            response.onSuccess {
                when (it.code()) {
                    200 -> {
                        mGetInformationLiveData.value = MyResponse.success(it.body()!!)
                    }
                    else -> {
                    }
                }
            }
            response.onFailure {
                mGetInformationLiveData.value = MyResponse.failed(it)
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.clear()
    }
}