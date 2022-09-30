package com.bps.retrofitexample2022.data.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object SingletonRetrofitFactory {
    fun <T> retrofitProvider(
        client: OkHttpClient = OkHttpClient().newBuilder().build(),
        serviceClass: Class<T>,
        baseUrl: String
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(serviceClass)
    }
}

