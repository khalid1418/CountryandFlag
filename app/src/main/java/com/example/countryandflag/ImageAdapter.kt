package com.example.countryandflag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countryandflag.databinding.LinerviewitemBinding
import com.example.countryandflag.network.FlagPhoto

class ImageAdapter:ListAdapter<FlagPhoto , ImageAdapter.FlagPhotoViewHolder>(DiffCallback){

    class FlagPhotoViewHolder(private var binding:LinerviewitemBinding):RecyclerView.ViewHolder(binding.root){
fun bind(FlagPhoto:FlagPhoto){
    binding.image = FlagPhoto
    binding.executePendingBindings()
}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagPhotoViewHolder {
        return FlagPhotoViewHolder(LinerviewitemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FlagPhotoViewHolder, position: Int) {
        val countryphoto = getItem(position)
        holder.bind(countryphoto)
    }
    companion object DiffCallback:DiffUtil.ItemCallback<FlagPhoto>(){
        override fun areItemsTheSame(oldItem: FlagPhoto, newItem: FlagPhoto): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: FlagPhoto, newItem: FlagPhoto): Boolean {
            return oldItem.flag == newItem.flag
        }

    }
}