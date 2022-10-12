package com.bps.retrofitexample2022.di

import com.bps.retrofitexample2022.data.network.api.OMDBApi
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo
import com.bps.retrofitexample2022.data.network.repo.OMDBRepoImpl
import com.bps.retrofitexample2022.data.network.retrofit.SingletonRetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Singleton
    @Provides
    fun provideOMDBApi(): OMDBApi {
        return SingletonRetrofitFactory
            .retrofitProvider(
                serviceClass = OMDBApi::class.java,
                baseUrl = "https://www.omdbapi.com"
            )
    }

    //Provide our apis
    @Singleton
    @Provides
    fun provideOMDBApiRepo(api: OMDBApi, dispatcher: Dispatchers): OMDBRepo {
        return OMDBRepoImpl(api, dispatcher)
    }
}
