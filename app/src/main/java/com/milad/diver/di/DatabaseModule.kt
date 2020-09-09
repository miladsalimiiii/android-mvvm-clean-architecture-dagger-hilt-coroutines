package com.milad.diver.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
   // single { AppDatabase.getInstance(androidContext()) }
}