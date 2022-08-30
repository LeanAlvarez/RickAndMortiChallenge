package com.mirai.challengeflow.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
import com.mirai.challengeflow.core.BaseViewHolder
import com.mirai.challengeflow.data.model.RickAndMortyModel
import com.mirai.challengeflow.databinding.ItemListDataBinding

class RickAndMortyDataAdapterprivate (val results: List<RickAndMortyModel>, private val itemClickListener: OnItemClickListener)  : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnItemClickListener {
        fun onItemClick(data: RickAndMortyModel)


    }


/*
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            ItemListDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ItemListDataBinding(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            } ?: return@setOnClickListener

            itemClickListener.onItemClick(results[position])

        }

        return holder

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is DataViewHolder -> holder.bind(results[position])
        }
    }

    override fun getItemCount(): Int = results.size

    private inner class DataViewHolder(val binding: ItemListDataBinding, val context: Context) :
        BaseViewHolder<RickAndMortyModel>(binding.root) {
        override fun bind(item: RickAndMortyModel) {
            //Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.poster_path}")
                //.centerCrop().into(binding.imgMovie)
        }


    }
*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}