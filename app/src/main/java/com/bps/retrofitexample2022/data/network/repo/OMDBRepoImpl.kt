package com.bps.retrofitexample2022.data.network.repo

import com.bps.retrofitexample2022.data.model.MovieModel
import com.bps.retrofitexample2022.data.model.Result
import com.bps.retrofitexample2022.data.network.api.OMDBApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OMDBRepoImpl @Inject constructor(
    private val api: OMDBApi,
    private val dispatcher: Dispatchers
) : OMDBRepo {
//    private val singletonRetrofitUsingOMDB = SingletonRetrofitFactory
//        .retrofitProvider(serviceClass = OMDBApi::class.java, baseUrl = "https://www.omdbapi.com")

    override suspend fun getMovieByName(movieName: String): Result<MovieModel?> {
        return withContext(dispatcher.IO) {
            val apiOMDBApi = api
            val response = apiOMDBApi.getMovieByName("9637719b", movieName)

            if (response.isSuccessful) {
                Result.Success(response.body())
            } else {
                Result.Error(Exception(response.errorBody().toString()))
            }
        }
    }
}
