package com.example.composeapp.domain.usecase

import com.example.composeapp.domain.model.User
import com.example.composeapp.domain.repository.UserRepository
import javax.inject.Inject

class ObtenerUsuariosUseCase @Inject constructor(private val repo: UserRepository) {
    suspend operator fun invoke(): List<User> {
        return repo.obtenerUsuarios()
    }
}
