package com.example.ktorsample.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shared.data.MovieResponse
import com.example.shared.net.service.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainVM : ViewModel() {
    private val _list =
        MutableLiveData<List<MovieResponse.ProductionCompany>>(emptyList())
    fun search() {
        viewModelScope.launch(Dispatchers.IO) {
            _list.postValue(MainRepository.search())
        }
    }
}