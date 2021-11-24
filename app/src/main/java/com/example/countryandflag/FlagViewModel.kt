package com.example.countryandflag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryandflag.network.FlagApi
import kotlinx.coroutines.launch
import java.lang.Exception

class FlagViewModel:ViewModel() {

    private val _state = MutableLiveData<String>()
     var state: LiveData<String> = _state

    init {
        getFlagimages()
    }



    fun getFlagimages(){
        viewModelScope.launch {
            try {


                val listResult = FlagApi.retrofitService.getPhotos()
                _state.value="Success: ${listResult.data.size} Mars photos retrieved"
            }catch (e:Exception){
                _state.value = "Failure: ${e.message}"
            }
        }
    }
}