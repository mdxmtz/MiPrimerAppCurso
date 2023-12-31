package com.example.miprimeraplicacion.recycler.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miprimeraplicacion.data.retrofit.RetrofitConnection
import com.example.miprimeraplicacion.data.retrofit.entity.get_character.GetCharacterResponse
import com.example.miprimeraplicacion.data.retrofit.entity.get_character.Result
import com.example.miprimeraplicacion.databinding.FragmentRecycleBinding
import com.example.miprimeraplicacion.recycler.adapter.MyAdapter
import com.example.miprimeraplicacion.recycler.data.Address
import com.example.miprimeraplicacion.recycler.data.ItemSelectedValue
import com.example.miprimeraplicacion.recycler.data.UserItem
import com.example.miprimeraplicacion.recycler.enums.SetData
import com.example.miprimeraplicacion.utils.extension_fun.showToast
import com.example.miprimeraplicacion.utils.extension_fun.toUserItemList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecycleBinding?=null
    private val binding get() = _binding!!


    private val getDataSource = SetData.Retrofit

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

        when(getDataSource){
            SetData.Retrofit -> getFromRetrofit()
            SetData.Dummy -> getDummyData()
        }

        //setUpView()

    }

    private fun getFromRetrofit() {

        RetrofitConnection().apiService.getCharacters().enqueue(object: Callback<GetCharacterResponse>{
            override fun onResponse(
                call: Call<GetCharacterResponse>,
                response: Response<GetCharacterResponse>
            ) {
                val characterList = response.body()?.results?: emptyList()
                showInRecycler(characterList)
                showToast("Todo bien en retrofit")

            }

            override fun onFailure(call: Call<GetCharacterResponse>, t: Throwable) {
                //showToast("Error")
                showToast("Error en retrofit")
            }

        })
    }

    private fun getDummyData() {

        val userItemList :List<UserItem> = getUserItem()

        val myAdapter = MyAdapter(dataList = userItemList)

        with(binding){
            rvFragmentRecycler.layoutManager = LinearLayoutManager(requireContext())
            rvFragmentRecycler.adapter = myAdapter
        }

    }

    /**
     *
     * Obtiene los valores de una lista de UserItem
     */
    private fun getUserItem(): List<UserItem> {
        val address1 = Address(
            number = 10,
            zipCode = "66636"
        )

        val addressDefault=Address()
//imageURLValue="https://www.anipedia.net/imagenes/tortuga-boba.jpg"
        val address2 = Address(
            number = 605,
            zipCode = "56874",
            streetName = "Benito"

        )
        val user1= UserItem(
            name = "Alan",
            address = address1,
            age = 38,
            imageURLValue = "https://inaturalist-open-data.s3.amazonaws.com/photos/202126881/original.jpg"
        )
        val user2= UserItem(
            name = "Juan",
            address = addressDefault,
            age = 15,
            imageURLValue = "https://static.wikia.nocookie.net/reinoanimalia/images/5/58/Tigre_de_bengala_wiki.png/revision/latest/thumbnail/width/360/height/360?cb=20130303105615&path-prefix=es"
        )

        val user3= UserItem(
            name = "Manuel",
            address = address2,
            age = 22,
            imageURLValue = "https://www.eltiempo.com/uploads/2023/02/14/63eb993c6cb20.png"

        )

        val user4= UserItem(
            name = "Angel",
            address = address1,
            age = 46,
            imageURLValue = "https://static.fundacion-affinity.org/cdn/farfuture/PVbbIC-0M9y4fPbbCsdvAD8bcjjtbFc0NSP3lRwlWcE/mtime:1643275542/sites/default/files/los-10-sonidos-principales-del-perro.jpg"
        )
        val user5= UserItem()

        return listOf(user1,user2,user3,user4,user5)
    }

    override fun onDetach(){
        super.onDetach()
        ItemSelectedValue.clearUser()
    }

    /* Cargar datos remotos*/
    private fun showInRecycler(list:List<Result>){
        val myAdapter = MyAdapter(list.toUserItemList())

        with(binding){
            rvFragmentRecycler.layoutManager=LinearLayoutManager(requireContext())
            rvFragmentRecycler.adapter=myAdapter
        }
    }


}