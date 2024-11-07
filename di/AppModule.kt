package com.example.myapplication.di

import SaveAppEntry
import android.app.Application
import com.example.myapplication.data.manager.LocalUserManagerImpl
import com.example.myapplication.domain.manager.LocalUserManager
import com.example.myapplication.domain.usecases.AppEntryUseCases
import com.example.myapplication.domain.usecases.ReadAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager =LocalUserManagerImpl(application)



    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}