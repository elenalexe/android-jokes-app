package com.example.jokesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.jokesapp.adapters.JokesAdapter
import com.example.jokesapp.api.DataProvider
import com.example.jokesapp.model.Joke
import com.example.jokesapp.repository.Repository

class JokesActivity : AppCompatActivity() {

    private lateinit var jokesAdapter: JokesAdapter
    private lateinit var viewModel: MainViewModel
    private var dataSource = ArrayList<Joke>()
    private val repo = Repository()
    private lateinit var animation: Animation
    private lateinit var jokesAnim: ImageView
    val viewModelFactory = MainViewModelFactory(repo)
    private lateinit var listview: ListView

    private fun fetchData(){
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
    }


    private fun fetchData(category: String){
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost(category)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        setContentView(R.layout.activity_jokes)
        val jokesListView = findViewById<ListView>(R.id.jokesActivityListView)

        DataProvider.myResponse.observe(this, androidx.lifecycle.Observer { response ->

            jokesListView.adapter = JokesAdapter(this, response)


        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.jokes_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.any){

            fetchData()
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }else if (item.itemId == R.id.xmas){

            fetchData("Christmas")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }else if (item.itemId == R.id.program){

            fetchData("Programming")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)

        }else if (item.itemId == R.id.misc){

            fetchData("Miscellaneous")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }else if (item.itemId == R.id.dark){

            fetchData("Dark")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }else if (item.itemId == R.id.pun){

            fetchData("Pun")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }else if (item.itemId == R.id.spook){

            fetchData("Spooky")
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo:
    ContextMenu.ContextMenuInfo?)
    {
        super.onCreateContextMenu(menu, v, menuInfo)
        // check if the menu is created for the targeted list
        if (v!!.id == R.id.jokesActivityListView)
        {
            // identify the item selected from the list
            val info = menuInfo as AdapterView.AdapterContextMenuInfo
            menu!!.setHeaderTitle("Do you want to report?")
            // load the visual structure of the menu
            getMenuInflater().inflate(R.menu.jokes_menu, menu);
        }
    }

    fun onClick(v: View?){
        jokesAnim = findViewById(R.id.animImageView)
        jokesAnim.setVisibility(View.VISIBLE)
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        jokesAnim.startAnimation(animation)

    }

}
