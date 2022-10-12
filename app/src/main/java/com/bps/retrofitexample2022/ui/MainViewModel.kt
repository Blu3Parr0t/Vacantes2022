package com.bps.retrofitexample2022.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bps.retrofitexample2022.data.model.MovieModel
import com.bps.retrofitexample2022.data.model.Result
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val dispatcher: Dispatchers,
    private val repo: OMDBRepo
) : AndroidViewModel(app) {
    private val _movie = MutableLiveData<MovieModel?>()
    val movie: LiveData<MovieModel?> = _movie

    fun getMovieByName(movieName: String) {
        viewModelScope.launch(dispatcher.IO) {
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

//    companion object {
//        fun provideViewModel(app: Application): MainViewModel =
//            MainViewModel(app, provideOMDBRepoApi())
//    }

}
