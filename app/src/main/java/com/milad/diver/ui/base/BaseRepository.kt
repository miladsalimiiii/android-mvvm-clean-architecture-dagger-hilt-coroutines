package com.milad.diver.ui.base

import io.reactivex.disposables.CompositeDisposable

open class BaseRepository {

    val mCompositeDisposable= CompositeDisposable()

    fun onClear(){
        mCompositeDisposable.clear()
    }
}