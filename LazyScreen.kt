package com.example.triptracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LazyScreen : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var progressPercentage: TextView
    private var progressStatus = 0
    private lateinit var totalDistanceCoveredView: TextView
    private lateinit var distanceLeftView: TextView
    private lateinit var stopNameView: TextView
    private lateinit var distanceToNextStopView: TextView
    private var currentStopIndex = 0
    private var isKm = true // True if the current unit is kilometers, false for miles


    data class Stop(val name: String, val distanceToNext: Int)

    private val stops = listOf(
        Stop("New Jersey", 0),
        Stop("Philadelphia", 3),
        Stop("Washington", 4),
        Stop("Pittsburgh", 5),
        Stop("Columbus", 6),
        Stop("Indianapolis", 7),
        Stop("St. Louis", 6),
        Stop("Kansas City", 5),
        Stop("Denver", 4),
        Stop("Salt Lake City", 3),
        Stop("Las Vegas", 2),
        Stop("Barstow", 5)
    )
    private val totalDistance = stops.sumOf { it.distanceToNext }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_lazy)

        initializeViews()

        progressBar.max = stops.size - 1
        val btnStop: Button = findViewById(R.id.btnStop)
        btnStop.setOnClickListener {
            if (currentStopIndex < stops.size - 1) {
                currentStopIndex++
                updateProgressAndUI()
            }
        }

        val listl: ImageButton = findViewById(R.id.listl)
        listl.setOnClickListener {
            val intent = Intent(this, LazyListStops::class.java)
            startActivity(intent)
        }

        // Setup for the convert button
        val btnConvert: Button = findViewById(R.id.btnConvert)
        btnConvert.setOnClickListener {
            isKm = !isKm
            updateProgressAndUI()
        }

        // Initial UI update
        updateProgressAndUI()
    }

    private fun initializeViews() {
        progressBar = findViewById(R.id.progressBar)
        progressPercentage = findViewById(R.id.tvProgressPercentage)
        totalDistanceCoveredView = findViewById(R.id.totalDistanceCovered2)
        distanceLeftView = findViewById(R.id.distanceLeft2)
        stopNameView = findViewById(R.id.stopName2)
        distanceToNextStopView = findViewById(R.id.distanceToNextStop2)


    }


    private fun updateProgressAndUI() {
        progressStatus = currentStopIndex
        progressBar.progress = progressStatus
        val percentage = (progressStatus.toFloat() / progressBar.max * 100).toInt()
        progressPercentage.text = "$percentage%"

        val distanceCovered = stops.subList(0, currentStopIndex + 1).sumOf { it.distanceToNext }
        val distanceLeft = totalDistance - distanceCovered
        val distanceToNext = stops.getOrNull(currentStopIndex + 1)?.distanceToNext ?: 0

        totalDistanceCoveredView.text = "Total distance covered: ${formatDistance(distanceCovered)}"
        distanceLeftView.text = "Distance left: ${formatDistance(distanceLeft)}"
        stopNameView.text = "Stop Name: ${stops[currentStopIndex].name}"
        distanceToNextStopView.text = "Distance to next stop: ${formatDistance(distanceToNext)}"
    }

    private fun formatDistance(distance: Int): String {
        val unit = if (isKm) "km" else "miles"
        val distanceValue = if (isKm) distance else convertKmToMiles(distance)
        return "$distanceValue $unit"
    }

    private fun convertKmToMiles(km: Int): Double = km * 0.621371


}
