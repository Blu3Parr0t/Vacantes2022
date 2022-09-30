package com.bps.retrofitexample2022.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo
import kotlinx.coroutines.launch

class MainViewModel(app: Application, private val repo: OMDBRepo) : AndroidViewModel(app) {

    private val _movieName = MutableLiveData<String?>()
    val movieName: LiveData<String?> = _movieName

    fun getMovieByName(movieName: String) {
        viewModelScope.launch {
            val movieFetched = repo.getMovieByName(movieName)
            _movieName.postValue(movieFetched?.title)
        }
    }

}
