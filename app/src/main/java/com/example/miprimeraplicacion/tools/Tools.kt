
package com.example.miprimeraplicacion.tools;

import android.content.Context
import android.widget.Toast
import com.example.miprimeraplicacion.data.Data

import com.example.miprimeraplicacion.data.User
import com.example.miprimeraplicacion.login.status.LoginEnum

import java.util.Locale

object Tools {

    fun showToast(context: Context, message: String) =
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    fun createUser(
        name: String,
        email: String,
        phoneNumber: String,
        password: String
    ): User {

        val userNameSufix = name.substring(0, 2).lowercase()
        val phoneSuf = phoneNumber.substring(0, 2).lowercase()


        //val userName=  "01$phoneNumber"
        val userName = "user$userNameSufix$phoneSuf"

        return User(
            userId = 0,
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            password = password,
            userName = userName
        )

    }


    fun loginWithCredentials(
        userName: String,
        password: String,
        callback: (LoginEnum,User) -> Unit
    ){
        var loginEnum = LoginEnum.FAILURE
        var userLogged : User = User()
        Data.getUserList().forEach {
            if (it.userName.equals(userName)
                && it.password.equals(password)
            ) {
                loginEnum= LoginEnum.SUCCESS
                userLogged = it
                return@forEach
            }
        }

        callback(loginEnum,userLogged)


    }
}

