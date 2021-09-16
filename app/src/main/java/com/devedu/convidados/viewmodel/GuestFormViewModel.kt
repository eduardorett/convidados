package com.devedu.convidados.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devedu.convidados.service.model.GuestModel
import com.devedu.convidados.service.repository.GuestRepository


// JA QUE USAMOS  O SINGLETON AQUI QUANDO PEGAMOS O REPOSITORIO TEM QUE SER ANDROIDVIEWMODEL AO INVES DE VIEWMODEL >

class GuestFormViewModel (application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(application) // recebe o repositorio

    ///////////////////////// PARA SAVE
    private var mSaveGuest = MutableLiveData<Boolean>() //mutable live data é para manipular como eu quiser os dados e devolver fixo para  a activity
    val saveGuest: LiveData<Boolean> = mSaveGuest // livedata não permite a manipulação, logo do mutable pro normal cristalizado

///////////////////////////// PARA LOAD
    private var mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest

//////////////////////////////
    fun save(id:Int, name: String,presence:Boolean) {

    val guest = GuestModel(id, name, presence
    ) // tem o "=" porque tem o id que é criado depois, tem que set valor basico

    if (id == 0) {
        mSaveGuest.value = mGuestRepository.save(guest)
    } else {
      mSaveGuest.value =  mGuestRepository.update(guest)
    }
}
    //////////////////////////////////////Q
    fun load(id: Int) {
        mGuest.value = mGuestRepository.get(id)
    }

}