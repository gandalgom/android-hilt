package com.gandalgom.sample.hilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import javax.inject.Qualifier

import com.gandalgom.sample.hilt.database.datasource.LoggerDataSource
import com.gandalgom.sample.hilt.database.datasource.LoggerInMemoryDataSource
import com.gandalgom.sample.hilt.database.datasource.LoggerLocalDataSource

@Qualifier
annotation class InMemoryLogger

@Qualifier
annotation class DatabaseLogger

@Suppress("unused")
@InstallIn(SingletonComponent::class)
@Module
abstract class LoggingDatabaseModule {
    @DatabaseLogger
    @Singleton
    @Binds
    abstract fun bindDatabaseLogger(impl: LoggerLocalDataSource): LoggerDataSource
}

@Suppress("unused")
@InstallIn(ActivityComponent::class)
@Module
abstract class LoggingInMemoryModule {
    @InMemoryLogger
    @ActivityScoped
    @Binds
    abstract fun bindInMemoryLogger(impl: LoggerInMemoryDataSource): LoggerDataSource
}
