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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.Data
import com.example.miprimeraplicacion.data.room.dao.UserDao
import com.example.miprimeraplicacion.data.room.entities.UserEntity
import com.example.miprimeraplicacion.databinding.FragmentLoginBinding
import com.example.miprimeraplicacion.databinding.FragmentRegisterBinding
import com.example.miprimeraplicacion.login.LoginViewModel
import com.example.miprimeraplicacion.login.status.InsertUserDBStatus
import com.example.miprimeraplicacion.tools.Tools
import com.example.miprimeraplicacion.utils.extension_fun.addUser
import com.example.miprimeraplicacion.utils.extension_fun.getAllUsers
import com.example.miprimeraplicacion.utils.extension_fun.getDb
import com.example.miprimeraplicacion.utils.extension_fun.showToast
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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

    private fun setUpListeners() {

        binding.btnFragmentRegisterRegistrar.setOnClickListener {

            with(binding) {

                val usuario=getUserByTils()

                binding.btnFragmentRegisterRegistrar.isEnabled = false

                registerViewModel.insertUserVM(requireContext(), usuario) {
                    when (it) {
                        InsertUserDBStatus.Load -> {
                            binding.clFragmentRegisterContainer.visibility = View.VISIBLE
                        }

                        InsertUserDBStatus.HideLoader -> binding.clFragmentRegisterContainer.visibility =
                            View.GONE

                        is InsertUserDBStatus.Failure -> {
                            binding.btnFragmentRegisterRegistrar.isEnabled = true
                            showToast(it.errorMessage)
                        }

                        is InsertUserDBStatus.Success -> {
                            showToast(it.successMessage)
                            // Cerrar vista
                            activity?.onBackPressedDispatcher?.onBackPressed()
                        }
                    }
                }

            }

        }


    }

    private fun getUserByTils() :UserEntity{
        with(binding){
            val name: String = tilFragmentRegisterName.getText()
            val email: String = tilFragmentRegisterEmail.getText()
            val phone: String = tilFragmentRegisterPhone.getText();
            val password: String = tilFragmentRegisterPassword.getText()
            val tel = Integer.parseInt(phone)

            val usuario = UserEntity(
                userId = tel,
                email = email,
                name = name,
                phoneNumber = phone,
                password = password
            )
            return usuario

        }
    }

    fun TextInputLayout.getText():String{
        return this.editText?.text.toString()
    }

}