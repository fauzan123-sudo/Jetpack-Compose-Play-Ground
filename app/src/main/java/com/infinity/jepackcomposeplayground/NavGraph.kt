package com.infinity.jepackcomposeplayground

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.infinity.jepackcomposeplayground.screen.DetailScreen
import com.infinity.jepackcomposeplayground.screen.HomeScreen


@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                navController = navHostController
            )
        }
        composable (route = Screen.Detail.route) {
            DetailScreen(
                navController = navHostController
            )
        }

    }
}