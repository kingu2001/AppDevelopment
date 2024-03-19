package com.example.tedo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user-table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name="Username")
    var username : String,
    @ColumnInfo(name="Password")
    var password : String,
    var reenterPassword : String? = "" )