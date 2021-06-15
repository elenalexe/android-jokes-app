package com.example.jokesapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapp.api.DataProvider
import com.example.jokesapp.model.Joke
import com.example.jokesapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            DataProvider.myResponse.value = response
        }
    }

    fun getPost(category: String) {
        DataProvider.myResponse.value = emptyList()
        viewModelScope.launch {
            val response = repository.getPost(category)
            DataProvider.myResponse.value = response
        }
    }
}