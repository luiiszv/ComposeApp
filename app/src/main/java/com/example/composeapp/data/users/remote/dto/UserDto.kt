package com.example.composeapp.data.users.remote.dto

data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val lastName: String,
    val role: String,
    val creationDate: String,
    val active: Boolean,
)