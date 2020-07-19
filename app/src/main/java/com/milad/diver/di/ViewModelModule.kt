package com.milad.diver.di

import com.milad.diver.ui.transactions.TransactionViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {

    viewModel { TransactionViewModel(get(),get()) }

}