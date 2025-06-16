package com.example.composeapp.domain.auth.repository

import com.example.composeapp.data.auth.remote.dto.LoginRequestDto
import com.example.composeapp.data.auth.remote.dto.LoginResponseDto

interface AuthRepository {

    suspend fun loginUser(loginRequestDto: LoginRequestDto): LoginResponseDto
}