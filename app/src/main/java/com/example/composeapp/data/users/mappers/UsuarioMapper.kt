package com.example.composeapp.data.users.mappers

import com.example.composeapp.data.users.local.entities.UserEntity
import com.example.composeapp.data.users.remote.dto.UserDto
import com.example.composeapp.domain.users.model.User


// Retrofit / API  -> Datos que llegan del backend
// 1. De la red (DTO) a dominio
// Cuando llega del backend y necesitas usarlo en la lógica de negocio
fun UserDto.toDomain(): User {
    return User(
        id = id,
        name = name,
        email = email,
        lastName = lastName,
        role = role,
        creationDate = creationDate,
        active = active,

    )
}



fun UserDto.toEntity() = UserEntity(
    id = id,
    name = name,
    email = email,
    password = password,
    lastName = lastName,
    role = role,
    creationDate = creationDate,
    active = active
    )




// 3. De la base de datos (Entidad) al dominio
// Cuando lees desde Room y necesitas usar los datos en la app
fun UserEntity.toDomain(): User {
    return User(
        id = id,
        name = name,
        email = email,
        lastName = lastName,
        role = role,
        creationDate = creationDate,
        active = active
    )
}
