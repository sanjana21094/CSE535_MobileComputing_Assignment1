package com.example.triptracker

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class LazyListStops : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "stopsList") {
                composable("stopsList") { StopsListScreen(navController, stopsList) }
                composable("stopDetails/{stopId}") { backStackEntry ->
                    // Retrieve the argument correctly
                    val stopIdString = backStackEntry.arguments?.getString("stopId")
                    val stopId = stopIdString?.toIntOrNull()

                    stopId?.let {
                        detailStructureLazy(it)
                    }
                }
            }
        }
    }
}

@Composable
fun StopsListScreen(navController: NavController, stops: List<StopDetails>) {
    LazyColumn {
        items(stops) { stop ->
            ListItem(stop = stop) {
                navController.navigate("stopDetails/${stop.stop}")
            }
        }
    }
}

@Composable
fun ListItem(stop: StopDetails, onClick: () -> Unit) {
    val typography = MaterialTheme.typography
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(10.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (stop.img != 0) { // Check if image resource ID is valid
                Image(
                    painter = painterResource(id = stop.img),
                    contentDescription = "Image of ${stop.place}",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stop.place,
                    style = typography.h6
                )
                Text(
                    text = "View Details",
                    style = typography.body2
                )
            }
        }
    }
}