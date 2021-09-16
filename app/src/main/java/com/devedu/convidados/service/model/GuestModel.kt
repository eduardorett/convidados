package com.devedu.convidados.service.model

//so serve para ler as info

// id está 0 para não ter que ser declarado na viewmodel desnecessariamente aonde não tem que ser usado
data class GuestModel(val id: Int = 0,val name: String, var presence:Boolean) // um e val pq é fixo vulgo nome, já a presença é var para ser setada como quiser

