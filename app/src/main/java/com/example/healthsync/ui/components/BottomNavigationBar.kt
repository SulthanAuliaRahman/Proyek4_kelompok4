package com.example.healthsync.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.healthsync.R
import com.example.healthsync.ui.theme.BottomNavColor
import com.example.healthsync.ui.theme.SelectedIndicator
import com.example.healthsync.ui.theme.SelectedItemColor
import com.example.healthsync.ui.theme.UnselectedItemColor

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("home", R.drawable.ic_home, "Home"),
        BottomNavItem("nutrition", R.drawable.ic_nutrition, "Nutrition"),
        BottomNavItem("activity", R.drawable.ic_activity, "Activity"),
        BottomNavItem("sleep", R.drawable.ic_sleep, "Sleep")
    )

    NavigationBar(
        containerColor = BottomNavColor,
        modifier = Modifier.height(120.dp) // Menyesuaikan tinggi navbar agar lebih proporsional
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(32.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label
                    )
                },
                selected = isSelected,
                onClick = { navController.navigate(item.route) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = SelectedItemColor,
                    unselectedIconColor = UnselectedItemColor,
                    selectedTextColor = SelectedItemColor,
                    unselectedTextColor = UnselectedItemColor,
                    indicatorColor = SelectedIndicator//Warna indikator bawaan saat item dipilih
                )
            )

        }
    }
}

data class BottomNavItem(val route: String, val icon: Int, val label: String)
