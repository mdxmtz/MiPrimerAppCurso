package com.example.miprimeraplicacion.data

import android.util.Log

object Data {

    init {
        Log.i("Royal", "Llamada desde init")
    }

    private var userList = mutableListOf<User>()



    fun addUser(user: User){
        userList.add(user)
    }

    fun getUserList () = userList



}

