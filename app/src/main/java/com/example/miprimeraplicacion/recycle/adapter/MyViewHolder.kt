package com.example.miprimeraplicacion.recycle.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimeraplicacion.R

class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val itemName : TextView = view.findViewById(R.id.item_recycler_text)

}