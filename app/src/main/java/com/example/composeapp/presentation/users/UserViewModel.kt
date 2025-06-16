package com.example.composeapp.presentation.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.core.network.ConnectivityObserver
import com.example.composeapp.core.network.NetworkStatus
import com.example.composeapp.domain.users.model.User
import com.example.composeapp.domain.users.usecase.ObtenerUsuariosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val obtenerUsuarios: ObtenerUsuariosUseCase,
    private val connectivityObserver: ConnectivityObserver
) : ViewModel() {

    private val _estadoConexion = MutableStateFlow<NetworkStatus>(NetworkStatus.Unavailable)
    val estadoConexion: StateFlow<NetworkStatus> = _estadoConexion.asStateFlow()

    init {
        // Observar el estado de la conexión al iniciarse el ViewModel
        viewModelScope.launch {
            connectivityObserver.observe().collect { status ->
                _estadoConexion.value = status
            }
        }
    }


    var usuarios by mutableStateOf<List<User>>(emptyList())
        private set

    fun cargarUsuarios() {
                viewModelScope.launch {
                    usuarios = obtenerUsuarios()
                }

    }
}