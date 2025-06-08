package com.example.composeapp.data.remote

import com.example.composeapp.data.remote.dto.UserDto
import retrofit2.http.GET



interface ApiService {
    @GET("users")
    suspend fun obtenerUsuarios(): List<UserDto>
}
