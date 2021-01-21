package com.example.todo.database

import java.time.LocalDateTime

data class Friend(
        var index:Int ?= null,
        var id : String ?= null,
        var color : String ?= null,
        var description : String ?= null,
        var createdAt : LocalDateTime?=null
){


}