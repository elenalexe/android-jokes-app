package com.example.jokesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.airbnb.lottie.LottieAnimationView
import com.example.jokesapp.repository.Repository
import java.util.Collections.rotate
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.timerTask

class MainActivity :  AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val repo = Repository()
    private lateinit var animation: Animation
    private lateinit var jokesAnim: ImageView

    val viewModelFactory = MainViewModelFactory(repo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // declare the first page elements
        val anyButton = findViewById<Button>(R.id.anybutton)
        anyButton.setOnClickListener {
            onClick(v = null)
            jokesAnim.startAnimation(animation)
            fetchData()
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
        val xmasButton = findViewById<Button>(R.id.christmasbutton)
        xmasButton.setOnClickListener {
            onClick(v = null)
            jokesAnim.startAnimation(animation)
            fetchData("Christmas")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
        val programButton = findViewById<Button>(R.id.programmbutton)
        programButton.setOnClickListener {
            onClick(v = null)
            jokesAnim.startAnimation(animation)
            fetchData("Programming")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
        val miscButton = findViewById<Button>(R.id.miscbutton)
        miscButton.setOnClickListener {
            onClick(v = null)
            jokesAnim.startAnimation(animation)
            fetchData("Miscellaneous")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
        val darkButton = findViewById<Button>(R.id.darkbutton)
        darkButton.setOnClickListener {
            onClick(v = null)
            jokesAnim.startAnimation(animation)
            fetchData("Dark")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
        val punButton = findViewById<Button>(R.id.punbutton)
        punButton.setOnClickListener {
            onClick(v = null)
            jokesAnim.startAnimation(animation)
            fetchData("Pun")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
        val spookButton = findViewById<Button>(R.id.spookybutton)
        spookButton.setOnClickListener {
            onClick(v = null)
            jokesAnim.startAnimation(animation)
            fetchData("Spooky")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }


    }

    private fun fetchData(){
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
    }


    private fun fetchData(category: String){
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost(category)
    }

    fun onClick(v: View?){
        jokesAnim = findViewById(R.id.animImageView)
        jokesAnim.setVisibility(View.VISIBLE)
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        jokesAnim.startAnimation(animation)

    }





}






