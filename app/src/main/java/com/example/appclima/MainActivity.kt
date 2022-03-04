package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.Exception


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

        if (Network.hayRed(this)) {
            //Toast.makeText(this,"Si hay Red", Toast.LENGTH_LONG).show()
            solicitudHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id=3527639&appid=fcb4bf74b2ec0bb39d6c08bb68ebc28d")
            //fcb4bf74b2ec0bb39d6c08bb68ebc28d
            //FCP 3527639

        } else {
            //Toast.makeText(this,"No hay una conexión a internet", Toast.LENGTH_LONG).show()
        }

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
    //Metodo para Volley
    private fun solicitudHTTPVolley(url:String){
        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url , Response.Listener<String>{
                response ->
            try {
                Log.d( "solicitudHTTPVolley", response)

            }catch (e: Exception){
            } }, Response.ErrorListener{} )
        queue.add(solicitud)
    }
}

