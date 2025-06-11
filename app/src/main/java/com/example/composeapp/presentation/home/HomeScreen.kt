package com.example.composeapp.presentation.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composeapp.presentation.nav.NavDestination

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    // UI que usa el ViewModel
    Button(onClick = { navController.navigate(NavDestination.USER_DETAIL) }) {
        Text("Ir a detalle")
    }
}