package com.example.miprimeraplicacion.recycler.data

import com.example.miprimeraplicacion.data.User

object ItemSelectedValue {

    var userItemSelected = UserItem()

    init {
        userItemSelected = UserItem()
    }

    fun clearUser() {
         userItemSelected = UserItem()
    }

    fun selectUser(user:UserItem){
        userItemSelected = user
        //igual a UserIteam()

    }

    fun getUser() = userItemSelected


}