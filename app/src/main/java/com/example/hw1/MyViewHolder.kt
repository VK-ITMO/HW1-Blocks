package com.example.hw1

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw1.R.color.blue
import com.example.hw1.R.color.red

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textInside = view.findViewById<TextView>(R.id.text_1)
    val parentImage = view.findViewById<ImageView>(R.id.image_view)
    val curResources = view.resources

    fun bind(number: Int) {
        textInside.text = "$number"
        if (number % 2 == 0){
            parentImage.background = ColorDrawable(curResources.getColor(red))
        }else{
            parentImage.background = ColorDrawable(curResources.getColor(blue))
        }
    }
}