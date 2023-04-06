package com.gandalgom.sample.hilt.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.gandalgom.sample.hilt.LogApplication
import com.gandalgom.sample.hilt.R
import com.gandalgom.sample.hilt.navigator.AppNavigator
import com.gandalgom.sample.hilt.navigator.Screens

class MainActivity : AppCompatActivity() {

    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = (application as LogApplication).serviceLocator.provideNavigator(this)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }
}