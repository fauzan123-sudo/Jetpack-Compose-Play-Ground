package com.infinity.jepackcomposeplayground

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.infinity.jepackcomposeplayground.ui.DETAIL_ARGUMENT_KEY
import com.infinity.jepackcomposeplayground.ui.Screen
import com.infinity.jepackcomposeplayground.ui.screen.DetailScreen
import com.infinity.jepackcomposeplayground.ui.screen.home.HomeScreen


@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
//            HomeScreen(
////                navController = navHostController
//            )
//        }
//        composable(route = Screen.Detail.route,
//            arguments = listOf(navArgument(DETAIL_ARGUMENT_KEY) {
//                type = NavType.IntType
//            })
//        ) {
//
//            DetailScreen(
//                navController = navHostController
//            )
        }
//
    }
}