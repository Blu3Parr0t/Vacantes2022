package com.bps.retrofitexample2022.ui

import androidx.lifecycle.ViewModel
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TempViewModel @Inject constructor(repo: OMDBRepo): ViewModel() {

    fun timberTime() {
        Timber.d("Zelda our function was called through DI")

    }
}
