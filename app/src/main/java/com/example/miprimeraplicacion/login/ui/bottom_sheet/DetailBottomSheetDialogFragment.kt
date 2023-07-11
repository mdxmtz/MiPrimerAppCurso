package com.example.miprimeraplicacion.login.ui.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.miprimeraplicacion.databinding.FragmentBottomSheetBinding
import com.example.miprimeraplicacion.recycler.data.ItemSelectedValue
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        _binding= FragmentBottomSheetBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpListeners()

    }

    private fun setUpListeners() {
        binding.tvFragmentDetailBottomSheetExit.setOnClickListener {
            dismiss()
        }

    }

    private fun setUpView() {

        isCancelable=false
        val name=ItemSelectedValue.getUser().name
        binding.tvFragmentDetailBottomSheetName.text = name

    }


}