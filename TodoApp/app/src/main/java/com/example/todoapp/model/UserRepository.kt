package com.example.todoapp.model

class UserRepository {
    val userList = mutableListOf<User>()

    fun create(name:String, email:String, password:Char, reenterPassword:Char) : User {
        val user = User(
            Name = name,
            Email = email,
            Password = password,
            ReenterPassword = reenterPassword
        )
        userList.add(user)
        return user
    }

    fun getAll() : MutableList<User>{
        return userList
    }

    fun delete(user : User) : User?{
        return userList.find { it.Email == user.Email }.also { userList.remove(it)}
    }

    fun update(user : User) : User?{
        val existingUser = userList.find { it.Email == user.Email }
        return existingUser?.apply {
            var name = Name
            var email = Email
            var password = Password
            var reenterPassword = ReenterPassword
        }
    }
}