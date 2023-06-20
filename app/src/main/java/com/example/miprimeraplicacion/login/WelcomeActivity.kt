package com.example.miprimeraplicacion.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.UserLogged
import com.example.miprimeraplicacion.databinding.ActivityLoginBinding

import com.example.miprimeraplicacion.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityWelcomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_welcome)

        setUpView();
    }

    fun setUpView(){
        val user = UserLogged.getUserLogged()


        binding.tvActivityWelcomeTitle.text= "Bienvenido ${user.name}, " +
                "tu telefono es ${user.phoneNumber}"
    }
}