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


    fun getUserByUsrname(un:String):User?{
        userList.forEach {
            if(it.userName.equals(un))
                return it

        }
        return null
    }

    fun getUserList () = userList



}

