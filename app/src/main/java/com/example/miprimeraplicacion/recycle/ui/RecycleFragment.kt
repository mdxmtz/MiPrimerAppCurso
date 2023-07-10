package com.example.miprimeraplicacion.recycle.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.databinding.FragmentLoginBinding
import com.example.miprimeraplicacion.databinding.FragmentRecycleBinding
import com.example.miprimeraplicacion.recycle.adapter.RecycleAdapter

class RecycleFragment : Fragment() {

    private var _binding: FragmentRecycleBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recycle, container, false)

        _binding= FragmentRecycleBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
    }

    private fun setUpView() {

        val data :List<String> = listOf<String>("Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe"
        )

        val myAdapter = RecycleAdapter(dataList = data)

        with(binding){
            rvFragmentRecycler.layoutManager = LinearLayoutManager(requireContext())
            rvFragmentRecycler.adapter = myAdapter
        }

    }
}