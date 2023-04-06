package com.gandalgom.sample.hilt.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

import com.gandalgom.sample.hilt.LogApplication
import com.gandalgom.sample.hilt.R
import com.gandalgom.sample.hilt.database.LoggerLocalDataSource
import com.gandalgom.sample.hilt.navigator.AppNavigator
import com.gandalgom.sample.hilt.navigator.Screens

@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    @Inject lateinit var logger: LoggerLocalDataSource
    private lateinit var navigator: AppNavigator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        populateFields(context)
    }

    private fun populateFields(context: Context) {
        val serviceLocator = (context.applicationContext as LogApplication).serviceLocator
        navigator = serviceLocator.provideNavigator(requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }
        view.findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }
        view.findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }
    }
}