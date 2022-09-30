package com.bps.retrofitexample2022.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.bps.retrofitexample2022.MainActivity
import com.bps.retrofitexample2022.R
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MainViewModel(MainActivity.ourApplication, OMDBRepo.provideOMDBRepoApi())
        viewModel.getMovieByName("it")

        viewModel.movieName.observe(viewLifecycleOwner) {
            Log.d("Zelda", "we got the response from the network the movie name is: $it")
        }
    }

}
