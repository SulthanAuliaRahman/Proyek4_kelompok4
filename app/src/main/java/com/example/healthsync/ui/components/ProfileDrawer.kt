package com.example.healthsync.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.healthsync.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDrawer(navController: NavController, content: @Composable () -> Unit) {
    var isDrawerOpen by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerContent = {
            ProfileDrawerContent { isDrawerOpen = false }
        },
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ) {
        Scaffold(
            topBar = {
                TopAppBar( //note: This material API is experimental and is likely to change or to be removed in the future.
                    title = { Text("HealthSync") },
                    navigationIcon = {
                        IconButton(onClick = { isDrawerOpen = true }) {
                            Icon( // Icon Logo
                                painter = painterResource(id = R.drawable.ic_launcher_foreground,),
                                contentDescription = "Logo",
                                modifier = Modifier.size(64.dp)
                            )
                        }
                    }
                )
            },
            content = { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    content()
                }
            }
        )
    }
}

@Composable
fun ProfileDrawerContent(onClose: () -> Unit) {
    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Divider()

        // Profile Section
        Column(modifier = Modifier.padding(16.dp)
            .align(alignment = Alignment.CenterHorizontally)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile Icon",
                modifier = Modifier.size(64.dp).align(alignment = Alignment.CenterHorizontally)
            )
            Text("Username", fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text("email@example.com", fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }

        Divider()


        // Navigation Items
        NavigationDrawerItem(
            icon = { Icon(painterResource(
                id = R.drawable.ic_setting),
                contentDescription = "Settings",
                modifier = Modifier.size(32.dp)) },
            label = { Text("Settings") },
            selected = false,
            onClick = { onClose() }

        )

        NavigationDrawerItem(
            icon = { Icon(painterResource(
                id = R.drawable.ic_info),
                contentDescription = "About",
                modifier = Modifier.size(32.dp)) },
            label = { Text("Daftar Pustaka") },
            selected = false,
            onClick = { onClose() }
        )
    }
}
