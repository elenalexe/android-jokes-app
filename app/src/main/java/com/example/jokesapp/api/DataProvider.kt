package com.example.jokesapp.api

import androidx.lifecycle.MutableLiveData
import com.example.jokesapp.model.Joke

object DataProvider {
    val myResponse: MutableLiveData<List<Joke>> = MutableLiveData()
}