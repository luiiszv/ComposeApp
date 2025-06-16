package com.example.composeapp.domain.users.usecase

import com.example.composeapp.domain.users.model.User
import com.example.composeapp.domain.users.repository.UserRepository
import javax.inject.Inject

class ObtenerUsuariosUseCase @Inject constructor(private val repo: UserRepository) {
    suspend operator fun invoke(): List<User> {
        return repo.obtenerUsuarios()
    }
}
