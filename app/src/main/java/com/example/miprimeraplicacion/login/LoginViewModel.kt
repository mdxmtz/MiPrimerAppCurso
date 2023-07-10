package com.example.miprimeraplicacion.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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






}