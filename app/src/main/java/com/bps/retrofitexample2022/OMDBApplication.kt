package com.bps.retrofitexample2022

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class OMDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
//        if (BuildConfig.DEBUG) {
        Timber.plant(Timber.DebugTree())
//        }
    }
}
