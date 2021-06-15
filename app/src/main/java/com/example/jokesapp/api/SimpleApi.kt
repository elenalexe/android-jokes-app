package com.example.jokesapp.api

import com.example.jokesapp.model.Joke
import com.example.jokesapp.model.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET("joke/Any?amount=10")
    suspend fun getPost(): Response

    @GET("joke/{category}?amount=10")
    suspend fun getPost(@Path("category") category: String): Response
}