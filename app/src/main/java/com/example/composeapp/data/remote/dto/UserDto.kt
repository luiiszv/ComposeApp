package com.example.composeapp.data.remote.dto

data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val lastName: String,
    val role: String,
    val creationDate: String,
    val active: Boolean,
)