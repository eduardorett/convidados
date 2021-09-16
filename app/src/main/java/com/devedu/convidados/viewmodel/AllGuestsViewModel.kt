package com.devedu.convidados.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devedu.convidados.service.model.GuestModel
import com.devedu.convidados.service.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext) // busca convidados no repo

    private val mGuestList = MutableLiveData<List<GuestModel>>()
   val guestList: LiveData<List<GuestModel>> = mGuestList             // cria a val para manipular as listas de convidados que virão



    fun load(){

         mGuestList.value =   mGuestRepository.getAll()  // pega todos os convidados e printa com o .value da lista mguest
        }


    fun delete (id:Int){
        mGuestRepository.delete(id)
    }

    fun allDelete(){
        Log.d("ELCIO", "chegou no delete")

        mGuestRepository.deleteAll()

    }




}