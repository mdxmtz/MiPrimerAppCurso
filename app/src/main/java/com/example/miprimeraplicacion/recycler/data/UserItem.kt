package com.example.miprimeraplicacion.recycler.data

data class UserItem(
    val name : String="Sin nombre",
    val age: Int=0,
    val imageURLValue : String = "Empty",
    val address: Address = Address(number=1000,
        "OctavioPaz","66636")


)


data class Address(
    val number: Int =0,
    val streetName: String = "Sin nombre",
    val zipCode: String = ""
){

}
