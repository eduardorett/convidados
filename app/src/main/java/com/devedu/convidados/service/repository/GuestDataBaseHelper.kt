package com.devedu.convidados.service.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.devedu.convidados.service.constants.DataBaseConstants


//     a class usa no repositorio para acessar banco- o sqlite  é class android que conecta com banco-  o CONTEXTO é porque precisa do contexto em um banco

class GuestDataBaseHelper(context:Context): SQLiteOpenHelper (context,DATABASE_NAME,null, DATABASE_VERSION){

    override fun onCreate(db: SQLiteDatabase?) { // ISSO FOI IMPLEMENTADO PARA USAR O SQL QUE É PARA BANDO DE DADOS LEVE VULGO MOBILE
        db?.execSQL(CREATE_TABLE_GUEST)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    companion object { // A VERSION E NAME  LEVAM A SQLITEOPENHELPER PARA TER UM JEITO FACIL DE MUDAR A VERSÃO E O NOME
        private const val DATABASE_VERSION =1
        private const val DATABASE_NAME = "Convidados.db"

       // É ASSIM QUE SE CRIAUMA TABELA VULGO CREATE TABLE GUEST
        private const val CREATE_TABLE_GUEST =
            ("create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
                    + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
                    + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);")
    }

}