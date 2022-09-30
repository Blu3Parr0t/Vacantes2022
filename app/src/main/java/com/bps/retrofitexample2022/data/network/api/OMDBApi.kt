package com.bps.retrofitexample2022.data.network.api

import com.bps.retrofitexample2022.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBApi {
    companion object {
        private const val MOVIE_REQUEST = "/"
    }

    @GET(MOVIE_REQUEST)
    suspend fun getMovieByName(
        @Query("apiKey") apiKey: String,
        @Query("t") movieName: String
    ): Response<MovieModel>
}
