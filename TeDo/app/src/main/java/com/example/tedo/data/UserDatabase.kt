package com.example.tedo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tedo.model.User
import com.example.tedo.model.UserDAO

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)

abstract class UserDatabase : RoomDatabase() {
    abstract fun userDAO() : UserDAO
}