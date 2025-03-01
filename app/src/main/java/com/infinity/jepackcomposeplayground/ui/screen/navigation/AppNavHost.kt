package com.infinity.jepackcomposeplayground.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.infinity.jepackcomposeplayground.ui.Screen
import com.infinity.jepackcomposeplayground.ui.screen.auth.AuthViewModel
import com.infinity.jepackcomposeplayground.ui.screen.auth.LoginScreen
import com.infinity.jepackcomposeplayground.ui.screen.auth.RegisterScreen
import com.infinity.jepackcomposeplayground.ui.screen.home.HomeScreen

@Composable
fun AppNavigation(viewModel: AuthViewModel) {
    val navController = rememberNavController()
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()

    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn) {
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
        } else {
            navController.navigate("login") {
                popUpTo("home") { inclusive = true }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = "login" // Set default start destination
    ) {
        composable("login") {
            LoginScreen(viewModel, navController)
        }
        composable("home") {
            HomeScreen(viewModel, navController)
        }
        composable("register") {
            RegisterScreen(navController)
        }
    }
}