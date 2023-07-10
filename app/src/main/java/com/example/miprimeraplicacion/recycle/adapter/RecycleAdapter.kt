package com.example.miprimeraplicacion.recycle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimeraplicacion.R

class RecycleAdapter(private val dataList:List<String>) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listValue=dataList[position]
        holder.itemName.text=listValue
    }


}