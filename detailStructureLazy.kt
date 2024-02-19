package com.example.triptracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun detailStructureLazy(stopId: Int) {
    // Find the stop details from the list using the stopId
    val stop = stopsList.find { it.stop == stopId }
    stop?.let { stopDetail ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stopDetail.place) },
                    backgroundColor = Color.Magenta,
                    contentColor = Color.White
                )
            }
        ) {
            Surface(
                modifier = Modifier.padding(it)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Image of the place
                    Image(
                        painter = painterResource(id = stopDetail.img),
                        contentDescription = "Image of ${stopDetail.place}",
                        modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // Place Name
                    Text(
                        text = stopDetail.place,
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Country
                    Text(
                        "Country: ${stopDetail.country}",
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(4.dp))


                    Text(
                        "Distance from Source: ${stopDetail.distanceFromSource}",
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    // Language
                    Text(
                        "Language: ${stopDetail.language}",
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(4.dp))


                    Text(
                        "Population: ${stopDetail.population}",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    } ?: run {
        Text("Stop not found", style = MaterialTheme.typography.h6)
    }
}
