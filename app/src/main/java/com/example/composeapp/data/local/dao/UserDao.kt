package com.example.composeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composeapp.data.local.entities.UserEntity
import com.example.composeapp.domain.model.User


//Organización Autónoma Descentralizada DAO ES Querys
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)
}