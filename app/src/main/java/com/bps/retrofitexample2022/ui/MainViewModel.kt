package com.bps.retrofitexample2022.ui

import android.app.Application
import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bps.retrofitexample2022.data.model.MovieModel
import com.bps.retrofitexample2022.data.model.Result
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo.Companion.FAiLURE
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo.Companion.SUCcESS
import kotlinx.coroutines.launch

class MainViewModel(app: Application, private val repo: OMDBRepo) : AndroidViewModel(app) {
    private val _movie = MutableLiveData<MovieModel?>()
    val movie: LiveData<MovieModel?> = _movie

    fun getMovieByName(movieName: String) {
        viewModelScope.launch {
            when (val movieFetched = repo.getMovieByName(movieName)) {
                is Result.Success -> {
                    _movie.postValue(movieFetched.data)
                }

                is Result.Error -> {
                    Log.d("Zelda", "Failure")
                    //Add a dialog box to show when an error happened. Or some other UI error displays.
                }
            }
        }
    }

}
