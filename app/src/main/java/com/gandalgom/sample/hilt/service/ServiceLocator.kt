package com.gandalgom.sample.hilt.service

import androidx.fragment.app.FragmentActivity

import com.gandalgom.sample.hilt.navigator.AppNavigator
import com.gandalgom.sample.hilt.navigator.AppNavigatorImpl

class ServiceLocator {

    fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}