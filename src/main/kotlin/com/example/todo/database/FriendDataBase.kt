package com.example.todo.database

data class FriendDataBase(
        var index : Int=0,
        var FriendList: MutableList<Friend> = mutableListOf()
) {

        fun init(){
            this.index = 0
            this.FriendList = mutableListOf()
            println( "[DEBUG] friend database init" )
        }
}
