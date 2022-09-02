package com.mirai.challengeflow.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColor
import com.bumptech.glide.Glide
import com.mirai.challengeflow.R
import com.mirai.challengeflow.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {


    private lateinit var binding: FragmentDetailBinding

    private var id_: Int = 0
    private var name: String = ""
    private var status: String = ""
    private var species: String = ""
    private var type: String = ""
    private var gender: String = ""
    private var origin: String = ""
    private var location: String = ""
    private var image:  String = ""
    private var created: String = ""




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailBinding.bind(view)


        arguments?.let { data ->
            id_ = data.getInt("id")
            name = data.getString("name").toString()
            status = data.getString("status").toString()
            species = data.getString("species").toString()
            type = data.getString("type").toString()
            gender = data.getString("gender").toString()
            origin = data.getString("origin").toString()
            location = data.getString("location").toString()
            image = data.getString("image").toString()
            created = data.getString("created").toString().substring(0, 10)
        }



        Log.d("Data pasada", "$id_, $name, $status, $species, $type, $gender, $origin, $location, $image, $created")

        Glide.with(requireContext()).load("$image").centerCrop().into(binding.imgCharacter)
        binding.tvName.text = name
        binding.tvEspecieDetail.text = gender
        binding.tvOriginDetail.text = species
        binding.tvLocationDetail.text = location
        binding.tvStatusDetail.text = status
        binding.tvDateCreated.text = created




    }

}