package com.gandalgom.sample.hilt.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

import com.gandalgom.sample.hilt.database.LogDao
import com.gandalgom.sample.hilt.database.LogDatabase

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideLogDao(database: LogDatabase): LogDao {
        return database.logDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): LogDatabase {
        return Room.databaseBuilder(applicationContext, LogDatabase::class.java, "logging.db")
            .build()
    }
}