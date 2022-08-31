package com.mirai.challengeflow.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.bumptech.glide.Glide
import com.mirai.challengeflow.core.BaseViewHolder
import com.mirai.challengeflow.data.model.RickAndMortyModel
import com.mirai.challengeflow.databinding.ItemListDataBinding

class RickAndMortyDataAdapter (val results: List<RickAndMortyModel>, private val itemClickListener: OnItemClickListener)  : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnItemClickListener {
        fun onItemClick(data: RickAndMortyModel)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
       val itemBinding = ItemListDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ItemViewHolder(itemBinding,parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION } ?: return@setOnClickListener
            itemClickListener.onItemClick(results[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(results[position])
        }
    }

    override fun getItemCount(): Int = results.size



    private inner class ItemViewHolder(val binding: ItemListDataBinding, val context: Context): BaseViewHolder<RickAndMortyModel>(binding.root){
        override fun bind(item: RickAndMortyModel) {
            Glide.with(context).load("${item.image}").centerCrop().into(binding.ivRM)
            binding.tvName.text = item.name
            binding.tvDescription.text = item.status
            binding.tvType.text = item.species
            binding.tvLocation.text = item.location.name
            binding.tvFirstCap.text = item.episode[0]
        }

    }




}


