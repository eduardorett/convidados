package com.devedu.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devedu.convidados.viewmodel.GuestFormViewModel
import com.devedu.convidados.R
import com.devedu.convidados.service.constants.GuestConstants
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel
private var mGuestId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel :: class.java) // concecta a viewmodel com a acitivy

        setListeners()
        observe()
        loadData()

        radio_presence.isChecked = true
    }

    override fun onClick(v: View?) {

        val id = v?.id

        if (id == R.id.button_save){

            val name = edit_name.text.toString() // 1 >captura o edit name
            val presence = radio_presence.isChecked // 2>captura a presença

            mViewModel.save(mGuestId,name,presence) // 3> manda para a fun da viewmodel

       }

        }

    private fun loadData(){
        val bundle = intent.extras
        if(bundle != null){
            mGuestId = bundle.getInt(GuestConstants.GUESTID)
            mViewModel.load(mGuestId)
        }
    }


    private fun observe(){
        ///////////////// CHAMA O SAVEGUEST, SE FUNCIONAR O PROCESSO SUCESSO
        mViewModel.saveGuest.observe(this, Observer {
            if(it){
            Toast.makeText(applicationContext,"Sucesso",Toast.LENGTH_SHORT).show()
        }else{
                Toast.makeText(applicationContext,"Falha",Toast.LENGTH_SHORT).show()
        }
            finish()

        })


 //POSSIBLIITA A EDIÇÃO DE UM GUEST
        mViewModel.guest.observe(this, Observer {
            edit_name.setText(it.name)

            if(it.presence){
                radio_presence.isChecked = true
            } else {
                radio_absent.isChecked = true
            }

        })

    }
    private fun setListeners(){
        button_save.setOnClickListener(this) // ativa o button save

    }
}