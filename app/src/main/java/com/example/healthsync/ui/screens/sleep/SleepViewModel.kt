package com.example.healthsync.ui.screens.sleep

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SleepViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SleepUIState("Ini adalah layar Tidur"))
    val uiState = _uiState.asStateFlow()
}

data class SleepUIState(val message: String)
