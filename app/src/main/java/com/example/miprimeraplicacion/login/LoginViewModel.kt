package com.example.miprimeraplicacion.login

import android.content.Context
import android.provider.ContactsContract.Intents.Insert
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miprimeraplicacion.data.room.dao.UserDao
import com.example.miprimeraplicacion.data.room.entities.UserEntity
import com.example.miprimeraplicacion.login.status.InsertUserDBStatus
import com.example.miprimeraplicacion.utils.extension_fun.addUser
import com.example.miprimeraplicacion.utils.extension_fun.getDBInstance
import com.example.miprimeraplicacion.utils.extension_fun.getDb
import com.example.miprimeraplicacion.utils.extension_fun.showToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel: ViewModel() {

    init {
        Log.e("Royal", "Creando ViewModel")
    }

    var name : String ="Alan"
    private val _appVersion = MutableLiveData<String>()

    //val appVersion: LiveData<String> get() = _appVersion


    val appVersion : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun insertUserVM(
        context: Context,
        userEntity: UserEntity,
        response: (InsertUserDBStatus)->Unit
    ){
        response(InsertUserDBStatus.Load)

        viewModelScope.launch {
            try{
                getDBInstance(context).userDao.insertUser(userEntity)
                delay(2000)
                response(InsertUserDBStatus.HideLoader)
                response(InsertUserDBStatus.Success("El usuario se agregó: ${userEntity.userId}"))

            }catch (e: Exception){
                response(InsertUserDBStatus.HideLoader)
                response(InsertUserDBStatus.Failure("Error al insertar usuario. (${e.message}"))
            }



        }


    }






}