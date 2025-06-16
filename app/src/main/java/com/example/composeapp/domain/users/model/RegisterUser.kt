package com.example.composeapp.domain.users.model

data class RegisterUser(
    val name: String,
    val email: String,
    val password: String,
    val lastName: String
)

//Por si se registra usuarios desde la app
