package com.example.miprimeraplicacion.login.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.databinding.FragmentLoginBinding
import com.example.miprimeraplicacion.databinding.FragmentRegisterBinding
import com.example.miprimeraplicacion.login.LoginViewModel
import com.example.miprimeraplicacion.utils.extension_fun.showToast


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
}