package com.example.hw1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonAdder: Button

    private val adapter = MyAdapter() // почему тут нельзя передать ресурсы?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        recyclerView = findViewById(R.id.recycler_view)
        buttonAdder = findViewById(R.id.addButton)

        recyclerView.adapter = adapter

        buttonAdder.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
        }

        adapter.setUpResources(resources)
        if (savedInstanceState != null) {
            val savedSize = savedInstanceState.getInt("saveSize")
            val newBlockList = List(savedSize) { it + 1 }
            adapter.setItems(newBlockList)
        } else {
            adapter.setItems(listOf(1, 2, 3, 4, 5))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("saveSize", adapter.itemCount)
    }
}