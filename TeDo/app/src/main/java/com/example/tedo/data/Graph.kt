package com.example.tedo.data

import android.content.Context
import androidx.room.Room

object Graph {

    /** Graph bruges til at initialisere databasen **/
    lateinit var database: UserDatabase
    val userRepository by lazy {
        UserRepository(userDAO = database.userDAO())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, UserDatabase::class.java, "user.DB").build()
    }
}