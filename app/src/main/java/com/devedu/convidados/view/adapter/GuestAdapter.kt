package com.devedu.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devedu.convidados.R

import com.devedu.convidados.service.model.GuestModel
import com.devedu.convidados.view.`interface`.GuestListener
import com.devedu.convidados.view.adapter.viewholder.GuestViewHolder


class GuestAdapter: RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList: List<GuestModel> = arrayListOf()
private lateinit var mListener: GuestListener

    override fun getItemCount(): Int {
   return mGuestList.count() // CONTA OS ITENS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {

        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest,parent,false)
        return GuestViewHolder(item,mListener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
       holder.bind(mGuestList[position])
    }

    fun updateGuest(list: List<GuestModel>){
        mGuestList = list
        notifyDataSetChanged()
    }


    fun attachListener(listener:GuestListener){
        mListener = listener
    }

}