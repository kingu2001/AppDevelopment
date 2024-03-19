package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity : Wish)
    @Query("Select * From `wish-table`")
    abstract fun getAllWishes() : Flow<List<Wish>>

    @Update
    abstract suspend fun updateAWish(entityWish : Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("Select * From `wish-table` Where id=:id")
    abstract fun getAWishById(id:Long):Flow<Wish>
}