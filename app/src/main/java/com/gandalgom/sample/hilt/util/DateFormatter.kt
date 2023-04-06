package com.gandalgom.sample.hilt.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

class DateFormatter {

    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat("yyyy MMM d HH:mm:ss")

    fun formatDate(timestamp: Long): String {
        return formatter.format(Date(timestamp))
    }
}