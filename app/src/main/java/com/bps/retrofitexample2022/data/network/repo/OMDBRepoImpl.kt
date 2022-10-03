package com.bps.retrofitexample2022.data.network.repo

import com.bps.retrofitexample2022.data.model.MovieModel
import com.bps.retrofitexample2022.data.model.Result
import com.bps.retrofitexample2022.data.network.api.OMDBApi
import com.bps.retrofitexample2022.data.network.retrofit.SingletonRetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class OMDBRepoImpl: OMDBRepo {
    private val singletonRetrofitUsingOMDB = SingletonRetrofitFactory
        .retrofitProvider(serviceClass = OMDBApi::class.java, baseUrl = "https://www.omdbapi.com")

    override suspend fun getMovieByName(movieName: String): Result<MovieModel?> {
        return withContext(Dispatchers.IO) {
            val apiOMDBApi = singletonRetrofitUsingOMDB
            val response = apiOMDBApi.getMovieByName("9637719b", movieName)

            if(response.isSuccessful) {
                Result.Success(response.body())
            } else {
                Result.Error(Exception(response.errorBody().toString()))
            }
        }
    }
}
