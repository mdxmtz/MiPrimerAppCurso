package com.example.miprimeraplicacion.utils.extension_fun

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment


fun Activity.setBooleanSharedPreferences(
    sharedPreferenceId: String,
    loginInSession : Boolean){

    val sharedPreferences =
        getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    val editor=sharedPreferences.edit()
    editor.putBoolean(sharedPreferenceId,loginInSession)
    editor.apply()
}

fun Activity.setStringSharedPreferences(
    sharedPreferenceId: String,
    value : String){

    val sharedPreferences =
        getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    val editor=sharedPreferences.edit()
    editor.putString(sharedPreferenceId,value)
    editor.apply()
}


fun Activity.getBooleanSharedPreferences(
    sharedPreferenceId: String,
    defaultValue : Boolean):Boolean{
    val sharedPreferences =
        getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean(sharedPreferenceId,defaultValue)
}

fun Fragment.getBooleanSharedPreferences(
    sharedPreferenceId: String,
    defaultValue : Boolean):Boolean{
    val sharedPreferences =
        requireActivity().getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean(sharedPreferenceId,defaultValue)
}
/*
fun Activity.getStringSharedPreferences(
    sharedPreferenceId: String,
    defaultValue : String):String{
    val sharedPreferences =
        getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    val value= sharedPreferences.getString(sharedPreferenceId,defaultValue)
    Log.i("Value: $value",value)

    return value
}
*/
fun Activity.getValues(){
    val sharedPreferences =
        getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    sharedPreferences.all.forEach { t, any ->
        Log.i("Royal", t+" "+any.toString())
        System.out.println("t "+t+", any: "+any.toString())

    }
}