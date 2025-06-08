package com.example.composeapp.domain.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val lastName: String,
    val role: String,
    val creationDate: String,
    val active: Boolean,
)
