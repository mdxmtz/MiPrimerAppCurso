package com.example.miprimeraplicacion.utils.extension_fun

import android.app.Activity
import androidx.fragment.app.Fragment

import com.example.miprimeraplicacion.data.room.AppDataBase
import com.example.miprimeraplicacion.data.room.entities.UserEntity


fun Fragment.getDb() = AppDataBase.getDatabase(requireContext())

fun Activity.getDb() = AppDataBase.getDatabase(this)

suspend fun AppDataBase.addUser(userEntity: UserEntity){
    this.userDao.insertUser(userEntity)
}

suspend fun AppDataBase.getAllUsers():List<UserEntity>{
    return this.userDao.getUsers()
}


suspend fun Activity.insertUser(userEntity: UserEntity) =
    getDb().userDao.insertUser(userEntity)
    //AppDataBase.getDatabase(this).userDao.insertUser(userEntity)

suspend fun Activity.getAllUser(userEntity: UserEntity) =
    AppDataBase.getDatabase(this).userDao.getUsers()


