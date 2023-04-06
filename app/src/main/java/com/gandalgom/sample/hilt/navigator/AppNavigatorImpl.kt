package com.gandalgom.sample.hilt.navigator

import androidx.fragment.app.FragmentActivity
import javax.inject.Inject

import com.gandalgom.sample.hilt.views.ButtonsFragment
import com.gandalgom.sample.hilt.views.LogsFragment
import com.gandalgom.sample.hilt.R

class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity): AppNavigator {
    override fun navigateTo(screen: Screens) {
        val fragment = when (screen) {
            Screens.BUTTONS -> ButtonsFragment()
            Screens.LOGS -> LogsFragment()
        }
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }
}