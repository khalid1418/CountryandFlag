package com.example.countryandflag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryandflag.network.Arraydata
import com.example.countryandflag.network.FlagApi
import com.example.countryandflag.network.FlagPhoto
import kotlinx.coroutines.launch
import java.lang.Exception

class FlagViewModel:ViewModel() {

    private val _state = MutableLiveData<String>()
     var state: LiveData<String> = _state
    private val _images = MutableLiveData<List<FlagPhoto>>()
    val images:LiveData<List<FlagPhoto>> = _images

    init {
        getFlagimages()
    }



    fun getFlagimages(){
        viewModelScope.launch {
            try {


//                val listResult = FlagApi.retrofitService.getPhotos()
                _images.value = FlagApi.retrofitService.getPhotos().data
                _state.value = "Success: Flag properties retrieved"
            }catch (e:Exception){
                _state.value = "Failure: ${e.message}"
            }
        }
    }
}