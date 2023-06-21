package com.example.miprimeraplicacion.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.UserLogged
import com.example.miprimeraplicacion.databinding.ActivityLoginBinding

import com.example.miprimeraplicacion.databinding.ActivityWelcomeBinding
import com.example.miprimeraplicacion.splash.SplashActivity
import com.example.miprimeraplicacion.tools.Tools
import com.example.miprimeraplicacion.utils.extension_fun.getBooleanSharedPreferences
import com.example.miprimeraplicacion.utils.extension_fun.setBooleanSharedPreferences

class WelcomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityWelcomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_welcome)

        setUpView()

        binding.tvActivityWelcomeTitle.setOnClickListener {
            /*val isUserLogged = getBooleanSharedPreferences("login",false)
            Tools.showToast(this,"El valor de SP en su campo login es -> $isUserLogged")
            */
            setBooleanSharedPreferences("login",false)
            Intent(this, SplashActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }


    }

    private fun setUpView(){
        //val user = UserLogged.getUserLogged()

        ///val title = getString(R.string.welcome_activity_title, user.name, user.phoneNumber)


        binding.tvActivityWelcomeTitle.text= title
        /** TODO
         * Obtener los datos de share preference y mostarlos
         * en el Textview
         */

    }
}