package com.gandalgom.sample.hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

import com.gandalgom.sample.hilt.service.ServiceLocator

@HiltAndroidApp
class LogApplication : Application() {

    lateinit var serviceLocator: ServiceLocator

    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocator()
    }
}