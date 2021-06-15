package com.example.jokesapp.model

data class Joke(
    val category: String,
    val type: String,
    val joke: String,
    val id: String,
    val setup: String,
    val delivery: String,
    val flags: Map<String, Boolean>
)
