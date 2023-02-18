package com.miteris.artistasws

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ArtistList(private val context: Activity, internal var artists: List<Artist>) : 
           ArrayAdapter<Artist>(context, R.layout.layout_list_artist, artists) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val listViewItem = inflater.inflate(R.layout.layout_list_artist, null, true)

        val textViewName = listViewItem.findViewById(R.id.textViewName) as TextView
        val textViewexpertise = listViewItem.findViewById(R.id.textViewExpertise) as TextView

        val artist = artists[position]
        textViewName.text = artist.name
        textViewexpertise.text = artist.expertise

        return listViewItem
    }
}