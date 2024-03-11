package com.example.todoapp.model
import android.text.format.DateFormat

data class ToDo(var Action:String? = null,
                var isDone:Boolean? = null,
                var Date:DateFormat? = null)