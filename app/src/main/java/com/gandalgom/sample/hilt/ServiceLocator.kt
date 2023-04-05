package com.gandalgom.sample.hilt

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.gandalgom.sample.hilt.navigator.AppNavigator
import com.gandalgom.sample.hilt.navigator.AppNavigatorImpl

class ServiceLocator(applicationContext: Context) {

    fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}