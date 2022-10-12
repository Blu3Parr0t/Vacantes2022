package com.bps.retrofitexample2022.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.bps.retrofitexample2022.MainActivity
import com.bps.retrofitexample2022.R
import com.bps.retrofitexample2022.data.network.repo.OMDBRepo
import com.bps.retrofitexample2022.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        tempViewModel.timberTime()

//        viewModel = MainViewModel.provideViewModel(this.activity?.application)
        viewModel.getMovieByName("it")

        viewModel.movie.observe(viewLifecycleOwner) {
            binding.movieModel = viewModel.movie.value
        }
    }

}
