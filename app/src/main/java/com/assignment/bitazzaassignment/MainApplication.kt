package com.assignment.bitazzaassignment

import android.app.Application
import com.assignment.bitazzaassignment.login.loginModule
import com.assignment.bitazzaassignment.splash.splashModule
import com.assignment.bitazzaassignment.webscoket.webSocketApiModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(webSocketApiModule, loginModule, splashModule)
        }
        Stetho.initializeWithDefaults(this)
    }
}