package com.example.miprimeraplicacion.login.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.databinding.FragmentLoginBinding
import com.example.miprimeraplicacion.utils.extension_fun.showToast

class LoginFragment : Fragment() {


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



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    fun setUpListeners(){
        binding.tvFragmentLoginList.setOnClickListener {
            //requireActivity().showToast("Mensaje")
            showToast("Click en fragmento")
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        }
        /*with(binding){
            btnFragmentLoginLogin.isEnabled =false
            binding.tvFragmentLoginError.text=getString(R.string.activity_login_tv_error)
            binding.btnFragmentLoginLogin.text=getString(R.string.activity_login_btn_login)
            binding.btnFragmentLoginRegister.text=getString(R.string.activity_login_btn_registro)
            tvFragmentLoginError.visibility=View.GONE
        }*/

    }

}