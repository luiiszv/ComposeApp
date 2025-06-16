package com.example.composeapp.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeapp.presentation.auth.LoginScreen
import com.example.composeapp.presentation.userDetail.UserDetaliScreen

@Composable
fun AppNavGraph(navController: NavHostController) {


    NavHost(navController = navController, startDestination = NavDestination.Login) {
        composable(NavDestination.Login) {
            LoginScreen(navController)
        }

        composable(
            route = NavDestination.USER_DETAIL,
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            UserDetaliScreen(navController, userId)
        }


    }
}

