package com.gandalgom.sample.hilt.database

interface LoggerDataSource {
    fun addLog(message: String)
    fun getAllLogs(callback: (List<Log>) -> Unit)
    fun removeLogs()
}