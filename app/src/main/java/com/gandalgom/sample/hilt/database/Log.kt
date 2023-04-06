package com.gandalgom.sample.hilt.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("logs")
data class Log(val message: String, val timeStamp: Long) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
