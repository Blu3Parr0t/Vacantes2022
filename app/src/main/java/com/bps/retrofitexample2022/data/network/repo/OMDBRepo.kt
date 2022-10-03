package com.bps.retrofitexample2022.data.network.repo

import com.bps.retrofitexample2022.data.model.MovieModel
import com.bps.retrofitexample2022.data.model.Result

interface OMDBRepo {

    suspend fun getMovieByName(movieName: String): Result<MovieModel?>

    companion object {
        fun provideOMDBRepoApi() = OMDBRepoImpl()
        const val SUCcESS = 1
        const val FAiLURE = -1
        const val IN_PrOGRESS = 0
    }
}
