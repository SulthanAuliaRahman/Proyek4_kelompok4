package com.example.healthsync.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Light Mode Colors
private val LightColorScheme = lightColorScheme(
    primary = BottomNavColor,      // Warna Bottom Navigation
    secondary = SelectedItemColor, // Warna Item yang dipilih
    tertiary = UnselectedItemColor, // warna Jika Tidak Di pilih
    background = BackgroundColor   // Warna Background
)

// Dark Mode Colors (sementara sama dengan Light Mode, bisa diubah nanti)
private val DarkColorScheme = darkColorScheme(
    primary = BottomNavColor,
    secondary = SelectedItemColor,
    tertiary = UnselectedItemColor,
    background = BackgroundColor
)

@Composable
fun HealthSyncTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Tidak menggunakan Dynamic Color
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
