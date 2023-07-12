package com.example.miprimeraplicacion.utils.extension_fun

import com.example.miprimeraplicacion.recycler.data.UserItem
import com.example.miprimeraplicacion.data.retrofit.entity.get_character.Result


fun List<Result>.toUserItemList():List<UserItem>{

    val userItemList = mutableListOf<UserItem>()

    this.forEach {
        userItemList.add(it.toUserItem())
    }

    return userItemList

}