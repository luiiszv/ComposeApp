package com.example.composeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeapp.data.auth.local.dao.AuthDao
import com.example.composeapp.data.users.local.dao.UserDao
import com.example.composeapp.data.users.local.entities.UserEntity




@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun authDao(): AuthDao


}
