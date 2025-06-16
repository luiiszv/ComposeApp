package com.example.composeapp.data.auth.repository

import com.example.composeapp.data.auth.local.dao.AuthDao
import com.example.composeapp.data.auth.remote.dto.LoginRequestDto
import com.example.composeapp.data.auth.remote.dto.LoginResponseDto
import com.example.composeapp.data.users.remote.ApiService
import com.example.composeapp.domain.auth.repository.AuthRepository
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(
    private val api: ApiService,
    private val authDao: AuthDao
) : AuthRepository {


    //Faltan cosas
    override suspend fun loginUser(loginRequestDto: LoginRequestDto): LoginResponseDto {
        return try {
            // Intenta loguear en el servidor
            val response = api.loginUser(loginRequestDto)

            // Podrías guardar al usuario logueado en la base local aquí, si quieres

            response
        } catch (e: IOException) {
            // Error de red, intenta login local
            println("Sin conexión, intentando login local...")

            val usuarioLocal = authDao.loginLocal(
                loginRequestDto.email,
                loginRequestDto.password
            )

            if (usuarioLocal != null) {
                // Puedes adaptar y devolver una LoginResponseDto equivalente
                return LoginResponseDto(
                    id = usuarioLocal.id,
                    email = usuarioLocal.email,
                    token = "local_user", // Puedes poner algún token simbólico
                    role = usuarioLocal.role
                )
            } else {
                throw Exception("Credenciales incorrectas (modo local)")
            }

        } catch (e: Exception) {
            println("Error inesperado en login: ${e.localizedMessage}")
            throw e
        }
    }


}