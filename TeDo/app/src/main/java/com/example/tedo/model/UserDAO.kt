package com.example.tedo.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract suspend fun addUser(userEntity : User)

    @Query("SELECT * FROM `user-table`")
    abstract fun getUsers() : MutableList<User>

    @Query("SELECT * FROM `USER-TABLE` WHERE id=:id")
    abstract fun getUserById(id : Int) : MutableList<User>

    @Update
    abstract suspend fun updateUser(userEntity: User)

    @Delete
    abstract suspend fun deleteUser(userEntity: User)
}