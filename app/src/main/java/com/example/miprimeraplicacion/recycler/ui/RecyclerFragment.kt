package com.example.miprimeraplicacion.recycler.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miprimeraplicacion.databinding.FragmentRecycleBinding
import com.example.miprimeraplicacion.recycler.adapter.MyAdapter
import com.example.miprimeraplicacion.recycler.data.Address
import com.example.miprimeraplicacion.recycler.data.UserItem

class RecyclerFragment : Fragment() {

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
/*
        val data :List<String> = listOf<String>("Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe",
            "Alan","Manuel","Juan","Jose", "Guadalupe"
        )

 */
        val userItemList :List<UserItem> = getUserItem()

        val myAdapter = MyAdapter(dataList = userItemList)

        with(binding){
            rvFragmentRecycler.layoutManager = LinearLayoutManager(requireContext())
            rvFragmentRecycler.adapter = myAdapter
        }

    }

    /**
     * Obtiene los valores de una lista de UserItem
     */
    private fun getUserItem(): List<UserItem> {
        val address1 = Address(
            number = "10",
            zipCode = 66636
        )

        val addressDefault=Address()

        val address2 = Address(
            number = "605",
            zipCode = 56874,
            streetName = "Benito"

        )
        val user1= UserItem(
            name = "Alan",
            address = address1,
            age = 38
        )
        val user2= UserItem(
            name = "Juan",
            address = addressDefault,
            age = 15
        )

        val user3= UserItem(
            name = "Manuel",
            address = address2,
            age = 22
        )

        val user4= UserItem(
            name = "Angel",
            address = address1,
            age = 46
        )
        val user5= UserItem()

        return listOf(user1,user2,user3,user4,user5)
    }


}