package com.bps.retrofitexample2022.data.network.repo

import com.bps.retrofitexample2022.data.model.MovieModel

interface OMDBRepo {

    suspend fun getMovieByName(movieName: String): MovieModel?

    companion object {
        fun provideOMDBRepoApi() = OMDBRepoImpl()
    }
}
