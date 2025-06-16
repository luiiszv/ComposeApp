package com.example.composeapp.data.users.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String,
    val password: String,
    val lastName: String,
    val role: String,
    val creationDate: String,
    val active: Boolean,
)