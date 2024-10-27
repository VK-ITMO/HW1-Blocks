package com.example.hw1

import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    final class Block(val numberText: String, val color: ColorDrawable)

    private lateinit var resources: Resources
    private val items = ArrayList<Block>()

    fun setUpResources(newResources: Resources) {
        resources = newResources
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        Log.d("ADD", "onCreateViewHolder")

        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    private fun createBlock(number: Int): Block {
        val color = ColorDrawable(
            resources.getColor(
                if (number % 2 == 0) R.color.red else R.color.blue,
                null
            )
        )
        return Block("$number", color)
    }

    fun setItems(list: List<Int>) {
        items.clear()
        list.forEach {
            items.add(createBlock(it))
        }

        notifyDataSetChanged() // TODO pain, need to re-write
    }

    fun addItems(item: Int) {
        items.add(createBlock(item))

        notifyDataSetChanged() // TODO pain, need to re-write
    }
}