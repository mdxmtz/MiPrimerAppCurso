package com.example.miprimeraplicacion.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraplicacion.databinding.ActivitySplashBinding
import com.example.miprimeraplicacion.login.LoginActivity
import com.example.miprimeraplicacion.login.LoginNCActivity
import com.example.miprimeraplicacion.login.WelcomeActivity
import com.example.miprimeraplicacion.login.ui.LoginFragment
import com.example.miprimeraplicacion.utils.extension_fun.getBooleanSharedPreferences
import com.example.miprimeraplicacion.utils.extension_fun.getValues
import com.example.miprimeraplicacion.utils.extension_fun.showToast

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        redirection()
        setUpListeners()

        //setContentView(R.layout.activity_splash)

    }

    private fun setUpListeners(){
        binding.animationView.setOnClickListener {

            with(binding.animationView){
                val isAnimating = isAnimating
                showToast("Hola Cargando")
                if(isAnimating.not())
                    playAnimation()
            }



        }

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
                Intent(this, LoginNCActivity::class.java).also { startActivity(it) }
            finish()
        },5_000)

    }

}