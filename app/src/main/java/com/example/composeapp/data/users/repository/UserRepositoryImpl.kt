package com.example.composeapp.data.users.repository

import com.example.composeapp.data.users.local.dao.UserDao
import com.example.composeapp.data.users.mappers.toDomain
import com.example.composeapp.data.users.mappers.toEntity
import com.example.composeapp.data.users.remote.ApiService
import com.example.composeapp.domain.users.model.User
import com.example.composeapp.domain.users.repository.UserRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

//Aquí conectas todo: API + Room + conversión → modelo limpio (User).
class UserRepositoryImpl @Inject constructor(
    private val api: ApiService,  //Remote
    private val dao: UserDao //Local
) : UserRepository {

     override suspend fun obtenerUsuarios(): List<User> {
        return try {
            val usuariosRemotosDto = api.obtenerUsuarios() //List de UserDto
            dao.insertUsers(usuariosRemotosDto.map { it.toEntity() }) //Guarda el da Db
            usuariosRemotosDto.map { it.toDomain() } //Devolvemos limpio Dominio
        } catch (e: IOException) {
            // Error de red (sin internet, timeout, etc.)
            println("Error de red: ${e.localizedMessage}")
            obtenerLocales() // Devuelve lo que ya estaba en la base local
        } catch (e: HttpException) {
            // Error HTTP (400, 404, 500, etc.)
            println("Error HTTP: ${e.localizedMessage}")
            obtenerLocales()
        } catch (e: Exception) {
            // Cualquier otro error
            println("Otro error: ${e.localizedMessage}")
            obtenerLocales()
        }
    }

    override suspend fun obtenerLocales(): List<User> {
        return dao.getUsers().map { it.toDomain() }
    }
}

