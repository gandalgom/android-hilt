package com.gandalgom.sample.hilt.service

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room

import com.gandalgom.sample.hilt.database.LogDatabase
import com.gandalgom.sample.hilt.database.LoggerLocalDataSource
import com.gandalgom.sample.hilt.navigator.AppNavigator
import com.gandalgom.sample.hilt.navigator.AppNavigatorImpl
import com.gandalgom.sample.hilt.util.DateFormatter

class ServiceLocator(applicationContext: Context) {

    private val logDatabase =
        Room.databaseBuilder(applicationContext, LogDatabase::class.java, "logging.db")
            .build()

    val loggerLocalDataSource = LoggerLocalDataSource(logDatabase.logDao())

    fun provideDateFormatter() = DateFormatter()

    fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}