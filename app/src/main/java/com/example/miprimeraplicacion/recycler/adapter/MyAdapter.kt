package com.example.miprimeraplicacion.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.recycler.data.UserItem
import com.example.miprimeraplicacion.utils.extension_fun.showToast

class MyAdapter(private val dataList:List<UserItem>) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val userItem=dataList[position]

        with(userItem){
            val fullAddress = "${address.streetName} ${address.number} , ${address.zipCode}"
            holder.tvName.text=name
            holder.tvAge.text="Edad: $age"
            holder.tvAddress.text=fullAddress
            //holder.btnDetail.text="Detalles"

            val contexto = holder.itemView.context

            holder.btnDetail.setOnClickListener {
                contexto.showToast("Click en ${name} , edad: ${age}", )


            }


        }



    }


}