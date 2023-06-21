package com.example.miprimeraplicacion.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.Data
import com.example.miprimeraplicacion.data.User
import com.example.miprimeraplicacion.data.UserLogged
import com.example.miprimeraplicacion.data.UserLoginStatus
import com.example.miprimeraplicacion.databinding.ActivityLoginBinding
import com.example.miprimeraplicacion.databinding.ActivityMainBinding
import com.example.miprimeraplicacion.register.RegisterActivity
import com.example.miprimeraplicacion.tools.Tools
import com.example.miprimeraplicacion.utils.extension_fun.getBooleanSharedPreferences
import com.example.miprimeraplicacion.utils.extension_fun.setBooleanSharedPreferences


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpView()
        setUpListeners()
        //showToast()
        binding.tvActivityLoginError.visibility=View.GONE

    }


    private fun setUpView(){
        //Toast.makeText(this,"La vista ha sido cargada", Toast.LENGTH_SHORT).show()
        with(binding){
            btnActivityLoginLogin.isEnabled =false
            binding.tvActivityLoginError.text=getString(R.string.activity_login_tv_error)
            binding.btnActivityLoginLogin.text=getString(R.string.activity_login_btn_login)
            binding.btnActivityLoginRegister.text=getString(R.string.activity_login_btn_registro)
            tvActivityLoginError.visibility=View.GONE
        }

    }

    private fun setUpListeners(){

        binding.tvActivityLoginList.setOnClickListener{
            val listCount = Data.getUserList().count().toString()
            /*val sharedPreferences = getSharedPreferences("User_Logged", Context.MODE_PRIVATE)
            val userLogged = sharedPreferences.getBoolean("login",false)
            */
            val userLogged = getBooleanSharedPreferences("login",false)

            Tools.showToast(this, userLogged.toString())



        }


        binding.btnActivityLoginRegister.setOnClickListener{
            Tools.showToast(this, "Registro presionado.")
            goToRegisterview()
        }

        binding.btnActivityLoginLogin.setOnClickListener{
            onLogin()
        }





        binding.tilActivityLoginUser.editText?.doOnTextChanged { text, start, before, count ->
            val valorDelEditText = text.toString()
            binding.tvActivityLoginError.visibility=View.GONE
            /*Log.i("Royal","Start $start")
            Log.i("Royal","Before: $before")
            Log.i("Royal","Count: $count")

             */
            //Tools.showToast(this, valorDelEditText)
            //Sintaxis if (eval) return1 else return2
            //val valor1 = if(10>4) "SI" else "NO"

            // Version Java
            binding.btnActivityLoginLogin.isEnabled =!valorDelEditText.trim().isEmpty()

            // Version kotlin
            binding.btnActivityLoginLogin.isEnabled =valorDelEditText.trim().isEmpty().not()
            validacion()
        }

        binding.tilActivityLoginPassword.editText?.doOnTextChanged { text, start, before, count ->
            binding.tvActivityLoginError.visibility=View.GONE
            val valorDelEditText = text.toString()
            binding.btnActivityLoginLogin.isEnabled =valorDelEditText.trim().isEmpty().not()
            validacion()
        }

        binding.tilActivityLoginPassword.editText?.setOnFocusChangeListener { v, hasFocus ->
            //if(hasFocus)
                binding.tvActivityLoginError.visibility = View.GONE
            //else
              //  binding.tvActivityLoginError.visibility = View.VISIBLE
        }

        binding.tilActivityLoginUser.setOnFocusChangeListener { v, hasFocus ->
            binding.tvActivityLoginError.visibility=View.GONE


        }
    }

    fun validacion(){
        val u = binding.tilActivityLoginUser.editText?.text.toString()
        val p = binding.tilActivityLoginPassword.editText?.text.toString()
        binding.btnActivityLoginLogin.isEnabled =
            u.trim().isNotEmpty() && p.trim().isNotEmpty()
    }

    private fun onLogin(){

        with(binding) {
            val userText = tilActivityLoginUser.editText?.text.toString()
            val passwordText = tilActivityLoginPassword.editText?.text.toString()


            Tools.loginWithCredentials(
                password = passwordText,
                userName = userText) {loginEnum, userLogged ->
                    when(loginEnum){
                        LoginEnum.SUCCESS -> {
                            setBooleanSharedPreferences("login", true)

                            /*
                            val sharedPreferences =
                                getSharedPreferences("User_Logged", Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()
                            editor.putBoolean("login",true)
                            editor.apply()
                            */

                            /** TODO Guardar datos nombre,telephoni, en sp
                             */


                            UserLogged.setUserLogged(userLogged)
                            goToWelcomeView()}
                        LoginEnum.FAILURE -> showLoginTvError()
                    }
                }



        }


    }

    private fun goToWelcomeView(){
        binding.tvActivityLoginError.visibility=View.INVISIBLE
        //Toast.makeText(this, "Login correcto", Toast.LENGTH_LONG).show()
        /*
        // Version Java
        val welcomeScreen = Intent(this@LoginActivity, WelcomeActivity::class.java)
        val name="Alan Altamira"
        welcomeScreen.putExtra("nameByLogin",name);
        welcomeScreen.putExtra("age", 15);
        startActivity(welcomeScreen)
         */
        // Version Kotlin
        Intent(this@LoginActivity, WelcomeActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }

    private fun showLoginTvError(){

        with(binding){
            tilActivityLoginUser.editText?.setText("")
            tilActivityLoginPassword.editText?.setText("")

            tilActivityLoginUser.clearFocus()
            tilActivityLoginPassword.clearFocus()

            tilActivityLoginUser.error="Introduce tu usuario"
            tilActivityLoginPassword.error="Introduce tu contraseña"
        }
        binding.tvActivityLoginError.visibility=View.VISIBLE
    }


    private fun goToRegisterview(){

        // Version Kotlin
        Intent(this@LoginActivity, RegisterActivity::class.java).apply {

        }.also {
            startActivity(it)
        }
        //finish()

    }

}