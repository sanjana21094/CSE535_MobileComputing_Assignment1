package com.example.triptracker

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class OptionScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_option)
        val popularButton : ImageButton = findViewById(R.id.popularButton)
        popularButton.setOnClickListener {
            val intent = Intent(this, LazyScreen::class.java)
            startActivity(intent)
        }
        val placeholderButton: ImageButton = findViewById(R.id.placeholderButton)
        placeholderButton.setOnClickListener{val intent = Intent(this , NormalScreen :: class.java)
            startActivity(intent)
        }

}}