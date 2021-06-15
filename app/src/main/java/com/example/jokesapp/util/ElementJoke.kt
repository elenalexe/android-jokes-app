package com.example.jokesapp.util

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jokesapp.MainViewModel
import com.example.jokesapp.MainViewModelFactory
import com.example.jokesapp.R
import com.example.jokesapp.api.DataProvider
import com.example.jokesapp.repository.Repository

class ElementJoke : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.element_jokes)

        val categLabel = findViewById<TextView>(R.id.categLabeltextView)
        val categInput = findViewById<TextView>(R.id.categInputtextView)
        val typeLabel = findViewById<TextView>(R.id.typeLabeltextView)
        val typeInput = findViewById<TextView>(R.id.typeInputtextView)
        val jokeLabel = findViewById<TextView>(R.id.jokeLabeltextView)
        val jokeInput = findViewById<TextView>(R.id.jokeInputtextView)
        val flagLabel = findViewById<TextView>(R.id.flagsLabeltextView)

        DataProvider.myResponse.observe(this, androidx.lifecycle.Observer { response ->

            response.forEach {
                categInput.text = it.category
               typeInput.text = it.type
                if (it.type == "single") {
                    jokeInput.text = it.joke
                } else {
                    jokeInput.text = "${it.setup.toString()} " +
                            "${it.delivery}"
                }

            }
        }
        )
    }
}