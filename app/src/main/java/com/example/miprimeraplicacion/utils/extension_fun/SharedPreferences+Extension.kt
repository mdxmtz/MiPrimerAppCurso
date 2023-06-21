package com.example.miprimeraplicacion.utils.extension_fun

import android.app.Activity
import android.content.Context
import android.util.Log


fun Activity.setBooleanSharedPreferences(
    sharedPreferenceId: String,
    loginInSession : Boolean){

    val sharedPreferences =
        getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    val editor=sharedPreferences.edit()
    editor.putBoolean(sharedPreferenceId,loginInSession)
    editor.apply()
}

fun Activity.getBooleanSharedPreferences(
    sharedPreferenceId: String,
    defaultValue : Boolean):Boolean{
    val sharedPreferences =
        getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean(sharedPreferenceId,defaultValue)
}

fun Activity.getValues(){
    val sharedPreferences =
        getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    sharedPreferences.all.forEach { t, any ->
        Log.i("Royal", t+" "+any.toString())
        System.out.println("t "+t+", any: "+any.toString())

    }
}