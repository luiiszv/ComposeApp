package com.example.composeapp.presentation.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeapp.presentation.components.EstadoConexionBanner


@Composable
fun UserScreen(
    userViewModel: UserViewModel = hiltViewModel()
) {
    val users = userViewModel.usuarios
    val network by userViewModel.estadoConexion.collectAsState()



    LaunchedEffect(Unit) {
        userViewModel.cargarUsuarios()
    }

    Column (modifier = Modifier.fillMaxSize()) {
        EstadoConexionBanner(network)

        Spacer(modifier = Modifier.padding(5.dp))


        LazyColumn {
            items(users) { user ->
                Text("${user.name} - ${user.email}")
            }
        }
    }








}

