package com.example.miprimeraplicacion.splash

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.Data
import com.example.miprimeraplicacion.databinding.ActivityLoginBinding
import com.example.miprimeraplicacion.databinding.ActivitySplashBinding
import com.example.miprimeraplicacion.login.LoginActivity
import com.example.miprimeraplicacion.login.WelcomeActivity
import com.example.miprimeraplicacion.tools.Tools
import com.example.miprimeraplicacion.utils.extension_fun.getBooleanSharedPreferences
import com.example.miprimeraplicacion.utils.extension_fun.getValues

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        redirection()

        //setContentView(R.layout.activity_splash)
    }

    private fun redirection(){

        val userLogged=getBooleanSharedPreferences("login", false)

        Log.i("Royal","userLogged: $userLogged ")

        getValues()

        Handler(Looper.getMainLooper()).postDelayed({
            if (userLogged)
                Intent(this, WelcomeActivity::class.java).also { startActivity(it) }
            else
                //Intent(this,LoginNCActivity::class.java).also { startActivity(it) }
                Intent(this, LoginActivity::class.java).also { startActivity(it) }
        },2_000)
        finish()
    }

}