package com.example.healthsync.ui.screens.nutrition

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun NutritionScreen(navController: NavController,
                    paddingValues: PaddingValues,
                    viewModel: NutritionViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Nutrition: ${uiState.message}",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
