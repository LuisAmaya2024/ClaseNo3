package com.example.sesion_3

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class formProductos : AppCompatActivity() {
    lateinit var campoproducto:EditText
    lateinit var campoprecio: EditText
    lateinit var campounidades:EditText
    lateinit var btnguardar:Button
    lateinit var conect:uConexion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_productos)
        campoproducto=findViewById(R.id.camponombreprod)
        campoprecio=findViewById(R.id.campoprecio)
        campounidades=findViewById(R.id.campounidad)
        btnguardar=findViewById(R.id.btn_guardar)

        conect = uConexion(this)
        btnguardar.setOnClickListener{
            var peticion: SQLiteDatabase = conect.writableDatabase

            var datosordenados = ContentValues();

            datosordenados.put("nombreProducto",campoproducto.text.toString())
            datosordenados.put("Precio",campoprecio.text.toString().toInt())
            datosordenados.put("UnidadesDisponibles",campounidades.text.toString().toInt())
            peticion.insert("productos",null,datosordenados)
            peticion.close()
            Toast.makeText(this,"Registrado correctamente",Toast.LENGTH_LONG).show()
            campoproducto.text.clear()
            campoprecio.text.clear()
            campounidades.text.clear()

            val traslado = Intent(this,MainActivity::class.java)
            startActivity(traslado)

        }


    }
}