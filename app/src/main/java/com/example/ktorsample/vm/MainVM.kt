package com.example.ktorsample.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorsample.data.Movie
import com.example.ktorsample.net.BaseConfig
import com.example.ktorsample.net.Endpoint
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.date.*
import kotlinx.coroutines.launch

class MainVM :ViewModel(){
    private val list_data : MutableLiveData<Movie> = MutableLiveData()
    fun getData(){
      viewModelScope.launch {
          val movie = BaseConfig(Endpoint().movie).getResponse
              // list_data.postValue(movie.toString())
      }
    }

}