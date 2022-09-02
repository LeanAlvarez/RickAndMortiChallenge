package com.mirai.challengeflow.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import com.mirai.challengeflow.R
import com.mirai.challengeflow.core.Resource
import com.mirai.challengeflow.data.model.RickAndMortyModel
import com.mirai.challengeflow.data.remote.RickAndMortyDataSource
import com.mirai.challengeflow.databinding.FragmentMainBinding
import com.mirai.challengeflow.presentation.DataViewModel
import com.mirai.challengeflow.presentation.DataViewModelFactory
import com.mirai.challengeflow.repository.DataRepositoryImpl
import com.mirai.challengeflow.repository.RetrofitClient
import com.mirai.challengeflow.ui.adapter.RickAndMortyDataAdapter


class MainFragment : Fragment(R.layout.fragment_main), RickAndMortyDataAdapter.OnItemClickListener{

    private lateinit var binding: FragmentMainBinding



    private lateinit var concatAdapter: ConcatAdapter
    private val viewModel by viewModels<DataViewModel> {
        DataViewModelFactory(DataRepositoryImpl(RickAndMortyDataSource(RetrofitClient.webService)))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)
        concatAdapter = ConcatAdapter()


        viewModel.fetchRickAndMortyData(1).observe(viewLifecycleOwner, Observer { result ->

            when(result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    Log.d("Data ->", "${result.data.results}")
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                    addAdapter(RickAndMortyDataAdapter( result.data.results, this@MainFragment))
                    }
                    binding.rvCharacters.adapter = concatAdapter
                }


                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                }



            }
        })



    }

    override fun onItemClick(data: RickAndMortyModel) {
       Log.d("Aprete este Personaje: ", "$data")
    }

}