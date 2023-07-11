package com.example.miprimeraplicacion.recycler.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimeraplicacion.R

class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

    //val itemName : TextView = view.findViewById(R.id.item_recycler_text)
    val tvName : TextView = view.findViewById(R.id.tv_item_recycler_name)
    val tvAge : TextView = view.findViewById(R.id.tv_item_recycler_age)
    val tvAddress : TextView = view.findViewById(R.id.tv_item_recycler_address_value)
    val btnDetail : TextView = view.findViewById(R.id.btn_item_recycler_detail)
    val btnSheet : TextView = view.findViewById(R.id.btn_item_recycler_sheet)
    val ivUserProfile : ImageView = view.findViewById(R.id.item_recycler_image)

}