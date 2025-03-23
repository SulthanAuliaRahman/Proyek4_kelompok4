package com.example.healthsync.ui.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState("Selamat datang di Home!"))
    val uiState = _uiState.asStateFlow()
}

data class HomeUIState(val message: String)
