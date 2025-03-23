package com.example.healthsync.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.healthsync.ui.components.ProfileDrawer

@Composable
fun HomeScreen(navController: NavController,
               paddingValues: PaddingValues,
               viewModel: HomeViewModel = viewModel()
) {
    ProfileDrawer(navController) {
        val uiState by viewModel.uiState.collectAsState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), // Pindahkan padding ke dalam screen
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Home: ${uiState.message}",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }

}
