package com.example.composeapp.domain.users.repository

import com.example.composeapp.domain.users.model.User

interface UserRepository  {
    suspend fun obtenerUsuarios(): List<User>
    suspend fun obtenerLocales(): List<User>
}
