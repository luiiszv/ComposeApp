package com.example.composeapp.data.users.remote

import com.example.composeapp.data.auth.remote.dto.LoginRequestDto
import com.example.composeapp.data.auth.remote.dto.LoginResponseDto
import com.example.composeapp.data.users.remote.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @GET("users")
    suspend fun obtenerUsuarios(): List<UserDto>




    @POST("auth/login")
    suspend fun loginUser(@Body loginRequest: LoginRequestDto ): LoginResponseDto


}
