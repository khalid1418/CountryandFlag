package com.example.countryandflag.network

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.countryandflag.ImageAdapter
import com.example.countryandflag.R

@BindingAdapter("flag")
fun bindImage(imgView: ImageView , imgUrl:String){
imgUrl.let {
    val imgUri = imgUrl.toUri().buildUpon()?.scheme("https")?.build()
    imgView.load(imgUri){
        placeholder(R.drawable.loading_animation)
        error(R.drawable.ic_broken_image)
    }
}
}
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView , data:List<FlagPhoto>?){
    val adapter = recyclerView.adapter as ImageAdapter
    adapter.submitList(data)
}
