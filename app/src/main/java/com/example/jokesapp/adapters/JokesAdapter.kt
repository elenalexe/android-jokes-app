package com.example.jokesapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.jokesapp.R
import com.example.jokesapp.model.Joke

class JokesAdapter(
        private val context: Context,
        private val sursaDate: List<Joke>


) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.element_jokes, parent, false)
        val currentJoke = sursaDate.elementAt(position)


        val category = rowView.findViewById<TextView>(R.id.categInputtextView)
        val type = rowView.findViewById<TextView>(R.id.typeInputtextView)
        val joke = rowView.findViewById<TextView>(R.id.jokeInputtextView)
        val id = rowView.findViewById<TextView>(R.id.idInputTextView)
        val flagList = rowView.findViewById<ListView>(R.id.flagsListView)
        category.text = currentJoke.category
        type.text = currentJoke.type
        joke.text = currentJoke.joke
        id.text = currentJoke.id
        if (currentJoke.type =="single") {
                   joke.text = currentJoke.joke
                } else {
                   joke.text = "${currentJoke.setup.toString()}" +
                           "${currentJoke.delivery}"
               }
        flagList.adapter = FlagsAdapter(context, currentJoke.flags)

        return rowView
    }

    override fun getItem(position: Int): Any {
        return sursaDate.elementAt(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return sursaDate.size
    }


}