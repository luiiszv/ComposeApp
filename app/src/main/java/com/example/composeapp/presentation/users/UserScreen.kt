package com.example.composeapp.presentation.users

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel




@Composable
fun UserScreen(
    userViewModel: UserViewModel = hiltViewModel()
) {
    val users = userViewModel.usuarios

    LaunchedEffect(Unit) {
        userViewModel.onEvent(UserEvent.CargarUsuarios)
    }

    LazyColumn {
        items(users) { user ->
            Text("${user.name} - ${user.email}")
        }
    }


}

