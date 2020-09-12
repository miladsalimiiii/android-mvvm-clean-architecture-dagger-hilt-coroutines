package com.milad.diver.common

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : MultiDexApplication() {

    companion object {
        private var sInstance = MyApplication()
        fun getInstance(): MyApplication {
            return sInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        sInstance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
//        startKoin {
//            androidLogger()
//            androidContext(this@MyApplication)
//            modules(
//                listOf(
//                    apiModule,
//                    databaseModule,
//                    repositoryModule,
//                    viewModelModule,
//                    utilModule
//                    )
//            )
//        }
    }
}