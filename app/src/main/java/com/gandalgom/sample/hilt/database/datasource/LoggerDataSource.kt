package com.gandalgom.sample.hilt.database.datasource

import com.gandalgom.sample.hilt.database.Log

interface LoggerDataSource {
    fun addLog(message: String)
    fun getAllLogs(callback: (List<Log>) -> Unit)
    fun removeLogs()
}