package com.example.sesion_3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class uConexion(context:Context): SQLiteOpenHelper(context,"Inventarioproductos.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val peticionSQLCreacion = "CREATE TABLE productos(" +
                "correlativo INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombreProducto TEXT,"+
                "Precio INTEGER,"+
                "UnidadesDisponibles INTEGER)"
       db!!.execSQL(peticionSQLCreacion)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}