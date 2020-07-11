package com.milad.diver.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    var mCompositeDisposable = CompositeDisposable()

    public override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.clear()
    }
}