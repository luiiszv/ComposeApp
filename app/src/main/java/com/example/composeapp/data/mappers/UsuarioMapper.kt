package com.example.composeapp.data.mappers

import com.example.composeapp.data.local.entities.UserEntity
import com.example.composeapp.data.remote.dto.UserDto
import com.example.composeapp.domain.model.User


// De la red (DTO) a dominio Cuando lklega de la red
fun UserDto.toDomain() = User(id, name, email, lastName, role, creationDate, active,
)



// De dominio a entidad de base de datos
fun User.toEntity() = UserEntity(id, name, email, lastName, role, creationDate, active)

// De entidad de base de datos a dominio Cuando esta en local
fun UserEntity.toDomain() = User(id, name, email, lastName, role,creationDate, active)
