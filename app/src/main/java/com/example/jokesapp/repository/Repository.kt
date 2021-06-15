package com.example.jokesapp.repository

import com.example.jokesapp.api.RetrofitInstance
import com.example.jokesapp.model.Joke

class Repository {

    suspend fun getPost(): List<Joke>{
        return RetrofitInstance.api.getPost().jokes
    }

    suspend fun getPost(category: String): List<Joke>{
        return RetrofitInstance.api.getPost(category).jokes
    }
}