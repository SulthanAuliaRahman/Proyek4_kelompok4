package com.example.healthsync.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.healthsync.ui.components.BottomNavigationBar
import com.example.healthsync.ui.components.ProfileDrawer
import com.example.healthsync.ui.screens.activity.ActivityScreen
import com.example.healthsync.ui.screens.home.HomeScreen
import com.example.healthsync.ui.screens.nutrition.NutritionScreen
import com.example.healthsync.ui.screens.sleep.SleepScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.fillMaxSize()
        ) {

            composable("home") { HomeScreen(navController, paddingValues) }
            composable("nutrition") { NutritionScreen(navController, paddingValues) }
            composable("activity") { ActivityScreen(navController, paddingValues) }
            composable("sleep") { SleepScreen(navController, paddingValues) }
        }
    }
}


