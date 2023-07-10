package com.example.miprimeraplicacion.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.os.Looper
//import android.os.Handler
import android.view.View
import android.widget.EditText
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.Data

import com.example.miprimeraplicacion.databinding.ActivityRegisterBinding
import com.example.miprimeraplicacion.tools.Tools
import com.google.android.material.textfield.TextInputLayout
import java.util.logging.Logger

//import java.util.logging.Handler

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        setUpView()
        setUpListeners()
        //setContentView(R.layout.activity_register)
        /**
         * Nombre
         * Correo
         *phone
         * Contraseña
         * */
    }

    /**
     * Funciones de normal
     * */
    /*
    fun getText(et:TextInputLayout):String{

        return et.editText?.text.toString()

    }*/

    /**
     * Funciòn de extension
     */
    fun TextInputLayout.getText():String{
        return this.editText?.text.toString()
    }
    /** Funciòn de exension minima**/
    //fun TextInputLayout.getText()=this.editText?.text.toString()

    private fun setUpView(){
        binding.tvActivityRegisterTitle.text="Registrate es gratis"
        binding.btnActivityRegisterRegistrar.text = "Registrar Usuario"
    }

    private fun setUpListeners(){

        binding.btnActivityRegisterRegistrar.setOnClickListener {

            binding.clActivityRegisterContainer.visibility = View.VISIBLE

            //val name : String = binding.tilActivityRegisterName.editText?.text.toString()
            val name : String = binding.tilActivityRegisterName.getText()
            val email : String = binding.tilActivityRegisterEmail.getText()
            val phone : String = binding.tilActivityRegisterPhone.getText();
            val password : String = binding.tilActivityRegisterPassword.getText()

            val userToSaveInCache= Tools.createUser(
                name =name,
                email = email,
                phoneNumber = phone,
                password = password
            )
/*
            val handler = Handler(Logger.getMainLooper())

            Handler.postDelayed({
                Data.addUser(userToSaveInCache)
                finish()
            }, 4000)*/

            Handler(Looper.getMainLooper()).postDelayed({

                val userName = userToSaveInCache.userName

                Tools.showToast(this, "Registro exitoso, tu usuario es $userName")
                /*
                if (userLogged)
                    Intent(this,WelcomeActivity::class.java).also { startActivity(it) }
                else
                    Intent(this,LoginNCActivity::class.java).also { startActivity(it) }
                */
                //finish()

                Data.addUser(userToSaveInCache)
                finish()

            },1_000)

        }

    }
}