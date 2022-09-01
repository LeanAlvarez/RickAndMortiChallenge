package com.mirai.challengeflow.ui

import android.content.ClipData
import android.content.ClipDescription
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mirai.challengeflow.R
import com.mirai.challengeflow.core.Resource
import com.mirai.challengeflow.data.model.RickAndMortyModel
import com.mirai.challengeflow.data.remote.RickAndMortyDataSource
import com.mirai.challengeflow.databinding.ActivityMainBinding
import com.mirai.challengeflow.databinding.FragmentItemListBinding
import com.mirai.challengeflow.databinding.ItemListContentBinding
import com.mirai.challengeflow.presentation.DataViewModel
import com.mirai.challengeflow.presentation.dataViewModelFactory
import com.mirai.challengeflow.repository.DataRepositoryImpl
import com.mirai.challengeflow.repository.RetrofitClient
import com.mirai.challengeflow.ui.adapter.RickAndMortyDataAdapter
import com.mirai.challengeflow.ui.placeholder.PlaceholderContent;



class itemListFragment : Fragment(R.layout.fragment_item_list), RickAndMortyDataAdapter.OnItemClickListener {

    private lateinit var binding: FragmentItemListBinding

    private lateinit var concatAdapter: ConcatAdapter
    private val viewModel by viewModels<DataViewModel> {
        dataViewModelFactory(DataRepositoryImpl(RickAndMortyDataSource(RetrofitClient.webService)))
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = FragmentItemListBinding.bind(view)
        concatAdapter = ConcatAdapter()



        viewModel.fetchRickAndMortyData(1).observe(viewLifecycleOwner, Observer { result ->



            when(result){

                is Resource.Loading -> {

                }

                is Resource.Success -> {

                       RickAndMortyDataAdapter(result.data.results, this@itemListFragment)


                    Log.d("Data ->", "${result.data.results}")
                }

                is Resource.Failure ->{

                }

            }
        })

    }

    override fun onItemClick(data: RickAndMortyModel) {
        TODO("Not yet implemented")
    }

}

