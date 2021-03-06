package com.example.countryandflag.network

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.example.countryandflag.FlagApiStatus
import com.example.countryandflag.ImageAdapter
import com.example.countryandflag.R

@BindingAdapter("flag")
fun bindImage(imgView: ImageView, imgUrl: String) {
    imgUrl.let {
          val imageLoader = ImageLoader.Builder(imgView.context)
        .componentRegistry { add(SvgDecoder(imgView.context)) }
        .build()



        val request = ImageRequest.Builder(imgView.context)
            .crossfade(true)
            .crossfade(500)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .data(imgUrl)
            .target(imgView)
            .build()

        imageLoader.enqueue(request)



    }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FlagPhoto>?) {
    val adapter = recyclerView.adapter as ImageAdapter
    adapter.submitList(data)
}



@BindingAdapter("flagApiStatus")
fun bindstatus(statusImageView: ImageView , status: FlagApiStatus){

    when(status){
        FlagApiStatus.LOADING -> {statusImageView.visibility = View.VISIBLE
        statusImageView.setImageResource(R.drawable.loading_animation)}
        FlagApiStatus.ERROR -> {View.VISIBLE
        statusImageView.setImageResource(R.drawable.ic_connection_error)}
        FlagApiStatus.DONE ->statusImageView.visibility = View.GONE
    }

}
