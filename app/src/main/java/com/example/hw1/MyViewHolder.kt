package com.example.hw1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textInside = view.findViewById<TextView>(R.id.text_1)
    val parentImage = view.findViewById<ImageView>(R.id.image_view)

    fun bind(data: MyAdapter.Block) {
        textInside.text = data.numberText;
        parentImage.background = data.color
    }
}