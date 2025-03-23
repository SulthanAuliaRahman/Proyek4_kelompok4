package com.example.healthsync.ui.screens.nutrition

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NutritionViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(NutritionUIState("Ini adalah layar Nutrisi"))
    val uiState = _uiState.asStateFlow()
}

data class NutritionUIState(val message: String)
