package com.example.triptracker

import CustomAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class NormalListStops : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_list_normal)

        val stops = listOf("Newark", "Jersey City", "Hoboken", "Manhattan")

        val images = listOf(R.drawable.newrak, R.drawable.jersey_city, R.drawable.hoboken, R.drawable.manhattan)


        val listView = findViewById<ListView>(R.id.listView)
        val adapter = CustomAdapter(this,stops,images)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent(this, newark::class.java).apply {
                putExtra("stops", stops[position])

            }
            startActivity(intent)


        }
    }

}



