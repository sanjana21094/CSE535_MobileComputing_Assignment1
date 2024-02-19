package com.example.triptracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NormalScreen : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var progressPercentage: TextView
    private lateinit var totalDistanceCoveredView: TextView
    private lateinit var distanceLeftView: TextView
    private lateinit var stopNameView: TextView
    private lateinit var distanceToNextStopView: TextView
    private var currentStopIndex = 0
    private var isKm = true // True if the current unit is kilometers, false for miles

    private val stops = listOf(
        Stop("New Jersey", 0), // Assuming "Start" represents the journey's start point
        Stop("Newark", 3),
        Stop("Jersey City", 4),
        Stop("Hoboken", 5),
        Stop("Manhattan", 6)
    )
    private val totalDistance = stops.sumOf { it.distanceToNext } // Total journey distance in km

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_normal)

        initializeViews()

        val btnStop: Button = findViewById(R.id.btn1Stop)
        btnStop.setOnClickListener {
            // Ensure that currentStopIndex does not exceed the number of stops
            if (currentStopIndex < stops.size - 1) {
                currentStopIndex++
                updateProgressAndUI()
            }
        }

        val list : ImageButton = findViewById(R.id.list)
        list.setOnClickListener { val intent = Intent(this,NormalListStops::class.java)
        startActivity(intent)}

        val btnConvert: Button = findViewById(R.id.btn1Convert)
        btnConvert.setOnClickListener {
            isKm = !isKm // Toggle the unit system
            updateProgressAndUI()
        }

        // Setting the max progress to 4 since there are 4 stops
        progressBar.max = 4

        // Displaying initial details without waiting for button press
        updateProgressAndUI(true)
    }

    private fun updateProgressAndUI(initial: Boolean = false) {
        // Setting the progress on the progress bar
        progressBar.progress = currentStopIndex

        // Calculating the percentage of the total journey completed
        val progressPercentageValue = (currentStopIndex.toFloat() / (stops.size - 1)) * 100
        progressPercentage.text = "${progressPercentageValue.toInt()}%"

        // Calculating the distance covered and distance left in kilometers
        val distanceCoveredKm = stops.subList(0, currentStopIndex + 1).sumOf { it.distanceToNext }
        val distanceLeftKm = totalDistance - distanceCoveredKm
        val distanceToNextKm = stops.getOrNull(currentStopIndex + 1)?.distanceToNext ?: 0

        // Converting distances to miles if needed
        val unit = if (isKm) "km" else "miles"
        val distanceCovered = if (isKm) distanceCoveredKm else convertKmToMiles(distanceCoveredKm)
        val distanceLeft = if (isKm) distanceLeftKm else convertKmToMiles(distanceLeftKm)
        val distanceToNext = if (isKm) distanceToNextKm else convertKmToMiles(distanceToNextKm)

        // Updating the UI with the current information
        totalDistanceCoveredView.text = "Total distance covered: $distanceCovered $unit"
        distanceLeftView.text = "Distance left: $distanceLeft $unit"
        stopNameView.text = "Stop Name: ${stops[currentStopIndex].name}"
        distanceToNextStopView.text = "Distance to next stop: $distanceToNext $unit"
    }

    private fun convertKmToMiles(km: Int): Double = km * 0.621371

    private fun initializeViews() {
        progressBar = findViewById(R.id.progressBarn)
        progressPercentage = findViewById(R.id.tvProgressPercentagen)
        totalDistanceCoveredView = findViewById(R.id.totalDistanceCovered)
        distanceLeftView = findViewById(R.id.distanceLeft)
        stopNameView = findViewById(R.id.stopName)
        distanceToNextStopView = findViewById(R.id.distanceToNextStop)
    }
}

data class Stop(
    val name: String,
    val distanceToNext: Int
)
