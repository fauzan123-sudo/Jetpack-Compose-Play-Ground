package com.infinity.jepackcomposeplayground.ui.screen.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.infinity.jepackcomposeplayground.ui.Screen
import com.infinity.jepackcomposeplayground.ui.screen.ProfileScreen
import com.infinity.jepackcomposeplayground.ui.screen.auth.AuthViewModel
import com.infinity.jepackcomposeplayground.ui.screen.home.HomeScreen

@Composable
fun BottomNavigation() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val select = remember { mutableStateOf(Icons.Default.Home) }
    val viewModel = remember { AuthViewModel() }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Blue
            ) {
                IconButton(
                    onClick = {
                        select.value = Icons.Default.Search
                        navigationController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (select.value == Icons.Default.Search) Color.White else Color.Gray
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Floating Action Button",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.Green
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(viewModel, navigationController)
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Preview
@Composable
fun MyBottomNav() {
    BottomNavigation()
}
