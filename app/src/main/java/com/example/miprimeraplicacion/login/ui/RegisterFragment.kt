package com.example.miprimeraplicacion.login.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.Data
import com.example.miprimeraplicacion.databinding.FragmentLoginBinding
import com.example.miprimeraplicacion.databinding.FragmentRegisterBinding
import com.example.miprimeraplicacion.login.LoginViewModel
import com.example.miprimeraplicacion.tools.Tools
import com.example.miprimeraplicacion.utils.extension_fun.showToast
import com.google.android.material.textfield.TextInputLayout


class RegisterFragment : Fragment() {

    private val registerViewModel : LoginViewModel by activityViewModels()


    private var _binding: FragmentRegisterBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_register, container, false)


        _binding= FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showToast(registerViewModel.name)



        setUpView()
        setUpListeners()
        setUpLiveDataListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun setUpLiveDataListeners() {
        registerViewModel.appVersion.observe(viewLifecycleOwner){

            /** Se ejecuta esta parte del codigo cuando se obtiuene algun cambio de la variable**/

            binding.tvFragmentRegisterVersion.text=it
        }
    }

    private fun setUpView(){
        binding.tvFragmentRegisterTitle.text="Registrate es gratis"
        binding.btnFragmentRegisterRegistrar.text = "Registrar Usuario"
    }

    private fun setUpListeners(){

        binding.btnFragmentRegisterRegistrar.setOnClickListener {

            binding.clFragmentRegisterContainer.visibility = View.VISIBLE

            //val name : String = binding.tilActivityRegisterName.editText?.text.toString()
            val name : String = binding.tilFragmentRegisterName.getText()
            val email : String = binding.tilFragmentRegisterEmail.getText()
            val phone : String = binding.tilFragmentRegisterPhone.getText();
            val password : String = binding.tilFragmentRegisterPassword.getText()

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

                Tools.showToast(requireContext(), "Registro exitoso, tu usuario es $userName")
                /*
                if (userLogged)
                    Intent(this,WelcomeActivity::class.java).also { startActivity(it) }
                else
                    Intent(this,LoginNCActivity::class.java).also { startActivity(it) }
                */
                //finish()

                Data.addUser(userToSaveInCache)
                findNavController().navigate(R.id.loginFragment)

            },1_000)

        }

    }

    fun TextInputLayout.getText():String{
        return this.editText?.text.toString()
    }

}