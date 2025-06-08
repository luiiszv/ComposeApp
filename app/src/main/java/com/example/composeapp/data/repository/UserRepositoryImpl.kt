package com.example.composeapp.data.repository

import com.example.composeapp.data.local.dao.UserDao
import com.example.composeapp.data.mappers.toDomain
import com.example.composeapp.data.mappers.toEntity
import com.example.composeapp.data.remote.ApiService
import com.example.composeapp.domain.model.User
import com.example.composeapp.domain.repository.UserRepository
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
            val usuariosRemotos = api.obtenerUsuarios().map { it.toDomain() }
            dao.insertUsers(usuariosRemotos.map { it.toEntity() })
            usuariosRemotos
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

