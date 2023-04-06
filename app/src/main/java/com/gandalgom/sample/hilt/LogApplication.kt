package com.gandalgom.sample.hilt

import android.app.Application
import com.gandalgom.sample.hilt.service.ServiceLocator

class LogApplication : Application() {

    lateinit var serviceLocator: ServiceLocator

    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocator(applicationContext)
    }
}