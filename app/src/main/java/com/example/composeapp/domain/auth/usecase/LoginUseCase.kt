package com.example.composeapp.domain.auth.usecase

import com.example.composeapp.data.auth.remote.dto.LoginRequestDto
import com.example.composeapp.data.auth.remote.dto.LoginResponseDto
import com.example.composeapp.domain.auth.repository.AuthRepository
import javax.inject.Inject


class LoginUseCase  @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(loginRequestDto: LoginRequestDto): LoginResponseDto{
        return authRepository.loginUser(loginRequestDto)
    }

//Lo mismo
//    suspend fun ejecutarLogin(loginRequestDto: LoginRequestDto): LoginResponseDto {
//        return authRepository.login(loginRequestDto)
//    }

}