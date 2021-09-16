package com.devedu.convidados.view.adapter.viewholder

import android.app.AlertDialog
import android.app.Application
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devedu.convidados.R
import com.devedu.convidados.service.model.GuestModel
import com.devedu.convidados.view.`interface`.GuestListener
import com.devedu.convidados.viewmodel.AllGuestsViewModel

//private   var mViewModel: AllGuestsViewModel = AllGuestsViewModel()

class GuestViewHolder(itemView: View,  val listener:GuestListener): RecyclerView.ViewHolder(itemView) {



    fun bind( guest: GuestModel){ // atribui os valores
        val textName = itemView.findViewById<TextView>(R.id.text_name)


    textName.text = guest.name




    textName.setOnClickListener{
        listener.onClick(guest.id)
    }

    textName.setOnLongClickListener{

        AlertDialog.Builder(itemView.context)
            .setTitle(R.string.remocao_convidado)
            .setMessage(R.string.deseja_remover)
            .setPositiveButton(R.string.remover){dialog,wich ->
                listener.onDelete(guest.id)
            }
            .setNeutralButton(R.string.cancelar,null)
            .show()
        true
    }
}
    }

