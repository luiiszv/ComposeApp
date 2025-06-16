package com.example.composeapp.presentation.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.data.auth.remote.dto.LoginRequestDto
import com.example.composeapp.domain.auth.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    var isEmailValido by mutableStateOf(false)
        private set

    var isPasswordValid by mutableStateOf(false)
        private set


    var email by mutableStateOf("")
        private set


    var password by mutableStateOf("")
        private set


    fun onEmailChanged(newEmail: String) {
        email = newEmail
        isEmailValido = validarEmail(newEmail)
    }

    fun onPasswordChenged(newPassword: String) {
        password = newPassword
        isPasswordValid= validPassword(newPassword)

    }


    //Validacion
    private fun validarEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validPassword(password: String): Boolean {
        return password.length >= 6;
    }

    fun onLoginClick() {
        println("Datos Enviados: $email $password")
        viewModelScope.launch {
            try {
                val response = loginUseCase(LoginRequestDto(email, password))
                println("Response: $response")
                // Aquí podrías actualizar estado, navegar, etc.
            } catch (e: Exception) {
                println("Login error: ${e.message}")
                // Manejo de error: mostrar mensaje, etc.
            }
        }
    }
}