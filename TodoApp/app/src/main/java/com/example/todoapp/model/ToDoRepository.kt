package com.example.todoapp.model
import android.text.format.DateFormat

class ToDoRepository {
    var todoList = mutableListOf<ToDo>()
    fun create(action:String, isDone:Boolean, date:DateFormat) : ToDo {
        var todo = ToDo(
            Action = action,
            isDone = isDone,
            Date = date
        )
        todoList.add(todo)
        return todo
    }

    fun getAll() : MutableList<ToDo>{
        return todoList
    }

    fun delete(action : String) : ToDo?{
        return todoList.find { it.Action == action}.also {todoList.remove(it)}
    }

    fun update(todo : ToDo) : ToDo?{
        var existingTodo = todoList.find { it.Action == todo.Action}
        return existingTodo?.apply {
            var action = todo.Action
            var isDone = todo.isDone
            var date = todo.Date
        }
    }

}