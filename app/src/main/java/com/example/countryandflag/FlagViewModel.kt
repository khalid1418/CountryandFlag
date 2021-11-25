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



enum class FlagApiStatus{LOADING, ERROR, DONE}

class FlagViewModel:ViewModel() {

    private val _state = MutableLiveData<FlagApiStatus>()
     var state: LiveData<FlagApiStatus> = _state
    private val _images = MutableLiveData<List<FlagPhoto>>()
    val images:LiveData<List<FlagPhoto>> = _images

    init {
        getFlagimages()
    }



    fun getFlagimages(){
        viewModelScope.launch {

            _state.value = FlagApiStatus.LOADING
            try {


//                val listResult = FlagApi.retrofitService.getPhotos()
                _images.value = FlagApi.retrofitService.getPhotos().data
                _state.value = FlagApiStatus.DONE
            }catch (e:Exception){
                _state.value = FlagApiStatus.ERROR
            }
        }
    }
}