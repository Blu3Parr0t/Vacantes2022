package com.bps.retrofitexample2022.data.network.api

import retrofit2.Response
import retrofit2.http.GET

interface RAWGVideoGamesApi {

    @GET()
    suspend fun anotherApiCall(): Response<Any>
}
