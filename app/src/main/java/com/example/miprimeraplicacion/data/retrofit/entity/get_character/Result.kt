package com.example.miprimeraplicacion.data.retrofit.entity.get_character

import com.example.miprimeraplicacion.recycler.data.Address
import com.example.miprimeraplicacion.recycler.data.UserItem

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {

    fun toUserItem(): UserItem {

        val address = Address(
            number = 100,
            streetName = this.location.name,
            zipCode = this.origin.name
        )

        return UserItem(
            name = this.name,
            age = 20,
            imageURLValue = this.image,
            address = address
        )

    }
}