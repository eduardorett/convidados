package com.devedu.convidados.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devedu.convidados.R
import com.devedu.convidados.service.constants.GuestConstants
import com.devedu.convidados.view.`interface`.GuestListener
import com.devedu.convidados.view.adapter.GuestAdapter
import com.devedu.convidados.viewmodel.AllGuestsViewModel
import kotlinx.android.synthetic.main.fragment_all.*
import kotlinx.android.synthetic.main.row_guest.*

class AllGuestsFragment : Fragment() {

    private lateinit var mViewModel: AllGuestsViewModel
private val mAdapter : GuestAdapter = GuestAdapter()
    private lateinit var  mListener : GuestListener

    ///////////////////////////////////////////////////////

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        mViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java) // intermediario para concetar model e viewmodel

        val root = inflater.inflate(R.layout.fragment_all,container,false)





        //RECYCLERVIEW: CRIA UM XML COM ESSE TIPO
        //1 - OBTER RECYCLER
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)


        //2- DEFINIR UM LAYOUT
        recycler.layoutManager = LinearLayoutManager(context)


        // 3 - DEFINIR UM ADAPTER

        recycler.adapter = mAdapter

        mListener =  object : GuestListener {

            override fun onClick(id: Int) { // da a possiblidade de alterar o guest clicando nele

                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle() // bundle constroi uma atividade nova
                bundle.putInt(GuestConstants.GUESTID, id)

                intent.putExtras(bundle) //intent cria a activivy e o putextra recebendo bundle coloca o id com as informações e da a possiblidade de alterar
                startActivity(intent) // gera na tela a ativdade
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
                mViewModel.load()
            }
        }

        mAdapter.attachListener(mListener)

        observer()


        return root
    }






    override fun onResume(){ // usado para atualizar a fragment com os convidados ao inves d eter que abrir e fechar
        super.onResume()
        mViewModel.load()
    }



private fun observer(){
    mViewModel.guestList.observe(viewLifecycleOwner, Observer {
        Log.d("Elcio","chegou notify")
        mAdapter.updateGuest(it)
    })
}
}