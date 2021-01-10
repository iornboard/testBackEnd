package com.example.todo.config

import com.example.todo.database.ToDoDataBase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(initMethod = "init")
    fun todoDataBase(): ToDoDataBase{
        return ToDoDataBase()
    }

}