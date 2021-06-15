package com.example.jokesapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.jokesapp.R

class FlagsAdapter(private val context: Context, private val date: Map<String, Boolean>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.flags_activity, parent, false)
        val flags = rowView.findViewById<TextView>(R.id.flagsActivityTextView)
        val currentElem = date.toList().get(position)
        flags.text = "${currentElem.first} : ${currentElem.second}"
        return rowView

    }

    override fun getItem(position: Int): Any {

        return date.toList().get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return date.size
    }

}