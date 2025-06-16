package com.example.composeapp.data.auth.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.composeapp.data.users.local.entities.UserEntity


@Dao
interface AuthDao {

    //Para el login local
    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    suspend fun loginLocal(email: String, password: String): UserEntity?
}