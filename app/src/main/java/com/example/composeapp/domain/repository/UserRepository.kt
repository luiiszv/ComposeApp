package com.example.composeapp.domain.repository

import com.example.composeapp.domain.model.User

interface UserRepository  {
    suspend fun obtenerUsuarios(): List<User>
    suspend fun obtenerLocales(): List<User>
}
