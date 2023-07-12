package com.example.miprimeraplicacion.data.retrofit


import com.example.miprimeraplicacion.data.retrofit.domain.GetCharacterList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitConnection {

    val retrofit  = Retrofit.Builder().apply {
        baseUrl("https://rickandmortyapi.com/api/")
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    val apiService = retrofit.create(GetCharacterList::class.java)

}