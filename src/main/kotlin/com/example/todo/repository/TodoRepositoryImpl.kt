package com.example.todo.repository

import com.example.todo.database.ToDoDataBase
import com.example.todo.database.Todo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl : TodoRepository {

    @Autowired
    lateinit var  toDoDataBase: ToDoDataBase

    override fun save(todo: Todo): Todo ? {

       return todo.index?.let{ index ->

            findOne(index)?.apply {
               this.title = todo.title
               this.description = todo.description
               this.schedule = todo.schedule
               this.updatedAt = LocalDateTime.now()
           }

       }?: kotlin.run {

            todo.apply {
               this.index = ++toDoDataBase.index
               this.createAt = LocalDateTime.now()
               this.updatedAt = LocalDateTime.now()
           }.run{
               toDoDataBase.todoList.add(todo)
               this
           }

       }

    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {

        return try{
            todoList.forEach {
                save(it)
            }
            true
        }catch (e: Exception){
            false
        }
    }

    override fun delete(index: Int): Boolean {

        return  findOne(index)?.let{
         toDoDataBase.todoList.remove(it)
         true
        }?: kotlin.run{
            false
        }
    }

    override fun findOne(index: Int): Todo? {
       return toDoDataBase.todoList.filter { it.index == index }.first()
    }

    override fun findAll(): MutableList<Todo> {
        return toDoDataBase.todoList
    }

}