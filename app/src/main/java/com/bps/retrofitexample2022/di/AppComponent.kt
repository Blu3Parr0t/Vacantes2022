package com.bps.retrofitexample2022.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppComponent {
    @Singleton
    @Provides
    fun provideDispatchers(): Dispatchers = Dispatchers

    @Singleton
    @Provides
    fun provideCoroutineIODispatcher(): CoroutineDispatcher =
        Dispatchers.IO

    //TODO Claudia
    //fun provideGlideCompoenent(): Glide
}
