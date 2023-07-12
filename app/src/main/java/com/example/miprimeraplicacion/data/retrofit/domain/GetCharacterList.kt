package com.example.miprimeraplicacion.data.retrofit.domain

import com.example.miprimeraplicacion.data.retrofit.entity.get_character.GetCharacterResponse
import retrofit2.Call
import retrofit2.http.GET

interface GetCharacterList {

    //https://rickandmortyapi.com/api/


    @GET("character")
    fun getCharacters() : Call<GetCharacterResponse>

}