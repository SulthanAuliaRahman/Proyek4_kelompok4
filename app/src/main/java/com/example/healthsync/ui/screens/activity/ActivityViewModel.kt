package com.example.healthsync.ui.screens.activity

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ActivityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ActivityUIState("Ini adalah layar Aktivitas"))
    val uiState = _uiState.asStateFlow()
}

data class ActivityUIState(val message: String)
