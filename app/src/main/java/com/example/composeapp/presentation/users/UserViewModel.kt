package com.example.composeapp.presentation.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.domain.model.User
import com.example.composeapp.domain.usecase.ObtenerUsuariosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val obtenerUsuarios: ObtenerUsuariosUseCase
) : ViewModel() {

    var usuarios by mutableStateOf<List<User>>(emptyList())
        private set

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.CargarUsuarios -> {
                viewModelScope.launch {
                    usuarios = obtenerUsuarios()
                }
            }
        }
    }
}