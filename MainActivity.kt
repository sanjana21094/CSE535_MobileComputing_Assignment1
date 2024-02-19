package com.example.triptracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_home)

    val startButton: Button = findViewById(R.id.startButton)
    startButton.setOnClickListener{
        val intent = Intent(this,OptionScreen::class.java)
        startActivity(intent)}
    }


}