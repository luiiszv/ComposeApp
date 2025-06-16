package com.example.composeapp.data.auth.remote.dto

data class LoginResponseDto(
    val id: String,
    val email: String,
    val role: String,
    val token: String
)