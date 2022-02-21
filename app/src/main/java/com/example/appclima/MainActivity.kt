package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.vidamrr.appclima.cuidades.CIUDAD")


        val ciudadfcp= Ciudad("Felipe Carrillo Puerto", 21, "Soleado")
        val ciudadvenecia= Ciudad("Ciudad De Venecia", 15, "Despejado")

        if(ciudad == "ciudad-carrillo"){
            //mostrar informacion de fcp
            tvCiudad?.text = ciudadfcp.nombre
            tvGrados?.text = ciudadfcp.grados.toString() + "°"
            tvEstatus?.text = ciudadfcp.estatus

        } else if(ciudad == "ciudad-venecia"){
            //mostrar informacion de venecia
            tvCiudad?.text = ciudadvenecia.nombre
            tvGrados?.text = ciudadvenecia.grados.toString() + "°"
            tvEstatus?.text = ciudadvenecia.estatus
        }else{
            Toast.makeText(this, "No se encuentra la información", Toast.LENGTH_SHORT).show()
        }
    }
}