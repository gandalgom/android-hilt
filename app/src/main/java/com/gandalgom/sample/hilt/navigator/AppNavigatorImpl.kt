package com.gandalgom.sample.hilt.navigator

import androidx.fragment.app.FragmentActivity
import com.gandalgom.sample.hilt.ui.ButtonsFragment
import com.gandalgom.sample.hilt.ui.LogsFragment
import com.gandalgom.sample.hilt.R

class AppNavigatorImpl(private val activity: FragmentActivity): AppNavigator {
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