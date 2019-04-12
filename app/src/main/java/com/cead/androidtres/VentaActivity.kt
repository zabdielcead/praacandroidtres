package com.cead.androidtres

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_venta.*

class VentaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta)
        val bundle: Bundle =  intent.extras
        val imagen =  bundle.getInt("imagen")
        val titulo =  bundle.getString("titulo")
        val descripcion =  bundle.getString("descripcion")
        val precion =  bundle.getInt("precio")

        imageView.setImageResource(imagen)
        txtituloAuto.text = titulo
        txtDescAuto.text = descripcion
        txtPrecioAuto.text = precion.toString()
    }
}
