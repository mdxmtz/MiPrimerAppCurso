package com.example.miprimeraplicacion.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.Data
import com.example.miprimeraplicacion.data.UserLogged
import com.example.miprimeraplicacion.data.room.AppDataBase
import com.example.miprimeraplicacion.data.room.dao.UserDao
import com.example.miprimeraplicacion.data.room.entities.UserEntity
import com.example.miprimeraplicacion.databinding.FragmentLoginBinding
import com.example.miprimeraplicacion.login.LoginEnum
import com.example.miprimeraplicacion.login.LoginViewModel
import com.example.miprimeraplicacion.login.WelcomeActivity
import com.example.miprimeraplicacion.register.RegisterActivity
import com.example.miprimeraplicacion.tools.Tools
import com.example.miprimeraplicacion.utils.extension_fun.addUser
import com.example.miprimeraplicacion.utils.extension_fun.getAllUsers
import com.example.miprimeraplicacion.utils.extension_fun.getBooleanSharedPreferences
import com.example.miprimeraplicacion.utils.extension_fun.getDb
import com.example.miprimeraplicacion.utils.extension_fun.setBooleanSharedPreferences
import com.example.miprimeraplicacion.utils.extension_fun.setStringSharedPreferences
import com.example.miprimeraplicacion.utils.extension_fun.showToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {


    //private  val loginViewModel : LoginViewModel by viewModels() // Crea un objeto
    private  val loginViewModel : LoginViewModel by activityViewModels() // Crea un objeto singleton


    private var _binding: FragmentLoginBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)

        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        setUpView()

        setUpLiveDataListeners()



    }

    private fun setUpLiveDataListeners() {


        loginViewModel.appVersion.observe(viewLifecycleOwner){

            /** Se ejecuta esta parte del codigo cuando se obtiuene algun cambio de la variable**/

            binding.tvFragmentLoginVersion.text=it
        }
    }

    private fun setUpView() {
        with(binding){
            btnFragmentLoginLogin.isEnabled =false
            binding.tvFragmentLoginError.text=getString(R.string.activity_login_tv_error)
            binding.btnFragmentLoginLogin.text=getString(R.string.activity_login_btn_login)
            binding.btnFragmentLoginRegister.text=getString(R.string.activity_login_btn_registro)
            tvFragmentLoginError.visibility=View.GONE
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun setUpListeners(){

        binding.tvFragmentLoginList.setOnClickListener{

            /*val version = binding.tilFragmentLoginVersion.editText?.text.toString()
            loginViewModel.appVersion.value=version

             */
            //findNavController().navigate(R.id.action_loginFragment_to_recycleFragment)




            val usuario = UserEntity(
                email="juan@gmail.com",
                name = "Juan",
                phoneNumber = "1234567891",
                password = "123456",
                userLogin = "juan"
            )

            val usuario2 = UserEntity(
                email="mario@sdf.cp",
                name = "Mario",
                phoneNumber = "1234567891",
                password = "123456",
                userLogin = "mario"
            )



            lifecycleScope.launch {

                val userDao: UserDao =getDb().userDao
                /*userDao.insertUser(usuario)
                showToast("Usuario Agregado")
                */
                getDb().addUser(usuario)
                delay(1000)

                getDb().addUser(usuario2)
                val userList = getDb().getAllUsers()
                showToast("el tamaño de la lista es ${userList.size} ")

            }



        }


        binding.btnFragmentLoginRegister.setOnClickListener{
            Tools.showToast(requireContext(), "Registro presionado.")
            goToRegisterview()
        }

        binding.btnFragmentLoginLogin.setOnClickListener{
            onLogin()
        }


        binding.tilFragmentLoginVersion.editText?.doOnTextChanged { text, start, before, count ->
            val valorEditText = text.toString().trim()
            loginViewModel.appVersion.value=valorEditText

        }




        binding.tilFragmentLoginUser.editText?.doOnTextChanged { text, start, before, count ->
            val valorDelEditText = text.toString()
            binding.tvFragmentLoginError.visibility=View.GONE

            // Version Java
            binding.btnFragmentLoginLogin.isEnabled =!valorDelEditText.trim().isEmpty()

            // Version kotlin
            binding.btnFragmentLoginLogin.isEnabled =valorDelEditText.trim().isEmpty().not()
            validacion()
        }

        binding.tilFragmentLoginPassword.editText?.doOnTextChanged { text, start, before, count ->
            binding.tvFragmentLoginError.visibility=View.GONE
            val valorDelEditText = text.toString()
            binding.btnFragmentLoginLogin.isEnabled =valorDelEditText.trim().isEmpty().not()
            validacion()
        }

        binding.tilFragmentLoginPassword.editText?.setOnFocusChangeListener { v, hasFocus ->
            //if(hasFocus)
            binding.tvFragmentLoginError.visibility = View.GONE
            //else
            //  binding.tvFragmentLoginError.visibility = View.VISIBLE
        }

        binding.tilFragmentLoginUser.setOnFocusChangeListener { v, hasFocus ->
            binding.tvFragmentLoginError.visibility=View.GONE


        }
    }


    fun validacion(){
        val u = binding.tilFragmentLoginUser.editText?.text.toString()
        val p = binding.tilFragmentLoginPassword.editText?.text.toString()
        binding.btnFragmentLoginLogin.isEnabled =
            u.trim().isNotEmpty() && p.trim().isNotEmpty()
    }


    private fun goToRegisterview(){

        // Version Kotlin
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        /*Intent(this@LoginActivity, RegisterActivity::class.java).apply {

        }.also {
            startActivity(it)
        }*/
        //finish()

    }

    private fun onLogin(){

        with(binding) {
            val userText = tilFragmentLoginUser.editText?.text.toString()
            val passwordText = tilFragmentLoginPassword.editText?.text.toString()


            Tools.loginWithCredentials(
                password = passwordText,
                userName = userText) {loginEnum, userLogged ->
                when(loginEnum){
                    LoginEnum.SUCCESS -> {
                        val activity = requireActivity()
                        activity.setBooleanSharedPreferences("login", true)
                        val user =  Data.getUserByUsrname(userText) // Buscar nombre en los datos
                        if(user==null){
                            activity.setStringSharedPreferences("name","")
                        }else
                            activity.setStringSharedPreferences("name",user.name)
                        /** TODO Guardar datos nombre,telephoni, en sp
                         */
                        UserLogged.setUserLogged(userLogged)
                        goToWelcomeView()}
                    LoginEnum.FAILURE -> showLoginTvError()
                }
            }



        }


    }


    private fun showLoginTvError(){

        with(binding){
            tilFragmentLoginUser.editText?.setText("")
            tilFragmentLoginPassword.editText?.setText("")

            tilFragmentLoginUser.clearFocus()
            tilFragmentLoginPassword.clearFocus()

            tilFragmentLoginUser.error="Introduce tu usuario"
            tilFragmentLoginPassword.error="Introduce tu contraseña"
        }
        binding.tvFragmentLoginError.visibility=View.VISIBLE
    }

    private fun goToWelcomeView(){
        binding.tvFragmentLoginError.visibility=View.GONE
        showToast("Ir a pantalla de bienvenida")
        //findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }


}