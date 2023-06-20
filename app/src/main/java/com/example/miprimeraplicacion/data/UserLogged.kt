package com.example.miprimeraplicacion.data

object UserLogged {
    private lateinit var userLogged : User

    fun setUserLogged(user:User){
        userLogged= user
    }

    fun getUserLogged() = userLogged
}