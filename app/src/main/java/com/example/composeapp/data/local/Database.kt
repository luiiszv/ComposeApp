package com.example.composeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeapp.data.local.dao.UserDao
import com.example.composeapp.data.local.entities.UserEntity




@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao


}
