package com.example.tedo.data

import com.example.tedo.model.User
import com.example.tedo.model.UserDAO
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDAO: UserDAO) {
    suspend fun addUser(user: User) {
        userDAO.addUser(user)
    }

    fun getUsers() : MutableList<User> = userDAO.getUsers()

    fun getUserById(id : Int) : MutableList<User>{
        return userDAO.getUserById(id)
    }

    suspend fun updateUser(user : User){
        userDAO.updateUser(user)
    }

    suspend fun deleteUser(user : User){
        userDAO.deleteUser(user)
    }
}