package com.example.triptracker


data class StopDetails(
    val stop: Int,
    val place: String,
    val country: String,
    val countryCode  : Int,
    val distanceFromSource: String,
    val language: String,
    val population: Int,
    val img: Int = 0
)

val stopsList = listOf(
    StopDetails(
        stop = 1,
        place = "Philadelphia",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "0 miles",
        language = "English",
        population = 1584000,
        img = R.drawable.phily
    ),
    StopDetails(
        stop = 2,
        place = "Washington DC",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "141 miles",
        language = "English",
        population = 705749,
        img = R.drawable.washington
    ),
    StopDetails(
        stop = 3,
        place = "Pittsburgh",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "305 miles",
        language = "English",
        population = 300286,
        img = R.drawable.pits
    ),
    StopDetails(
        stop = 4,
        place = "Columbus",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "477 miles",
        language = "English",
        population = 898553,
        img = R.drawable.colombus
    ),

    StopDetails(
        stop = 5,
        place = "Indianapolis",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "648 miles",
        language = "English",
        population = 876384,
        img = R.drawable.indianapolis
    ),
    StopDetails(
        stop = 6,
        place = "St. Louis",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "907 miles",
        language = "English",
        population = 300576,
        img = R.drawable.st
    ),
    StopDetails(
        stop = 7,
        place = "Kansas City",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "1118 miles",
        language = "English",
        population = 495327,
        img = R.drawable.kansas
    ),
    StopDetails(
        stop = 8,
        place = "Denver",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "1739 miles",
        language = "English",
        population = 727211,
        img = R.drawable.denver

    ),
    StopDetails(
        stop = 9,
        place = "Salt Lake City",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "2175 miles",
        language = "English",
        population = 200567,
        img = R.drawable.salt
    ),
    StopDetails(
        stop = 10,
        place = "Las Vegas",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "2521 miles",
        language = "English",
        population = 651319,
        img = R.drawable.lv
    ),
    StopDetails(
        stop = 11,
        place = "Barstow",
        country = "USA",
        countryCode = 1,
        distanceFromSource = "2685 miles",
        language = "English",
        population = 23954,
        img = R.drawable.barstow
    )
)