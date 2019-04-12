package com.cead.androidtres

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // -- para crear un archivo drawable para los botones custom  click derecho en drawable new -> Drawable resource file
    //  -- https://www.materialpalette.com/colors
    // -- diferentes layouts
    // -- dp es para imagenes botones etc.
    // -- sp es para texto
    // secondactivity : relativelayout
    // thirdactivity : linearlayout
    // fouractivity: juego del gato
    // fiveactivity: ListView   click derecho en layout -> new Layout resource file
    // sixactivity: Gridview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun eventosBtn( view: View){
        if(nuevaOperacion){
            editText.setText("")
        }
        nuevaOperacion = false

        var btnCliqueado = view as Button
        var valorDelBtn : String  =  editText.text.toString()


        when (btnCliqueado.id){
            btnCero.id -> { valorDelBtn += "0" }
            btnUno.id -> { valorDelBtn += "1" }
            btnDos.id -> { valorDelBtn += "2" }
            btnTres.id -> { valorDelBtn += "3" }
            btnCuatro.id -> { valorDelBtn += "4" }
            btnCinco.id -> { valorDelBtn += "5" }
            btnSeis.id -> { valorDelBtn += "6" }
            btnSiete.id -> { valorDelBtn += "7" }
            btnOcho.id -> { valorDelBtn += "8" }
            btnNueve.id -> { valorDelBtn += "9" }
            btnPunto.id -> { valorDelBtn += "." }
            btnNextActivity.id -> {
                var intent = Intent(this@MainActivity, SecondActivity:: class.java)
                this.startActivity(intent)

            }
            btnMasMenos.id -> { valorDelBtn = "-" + valorDelBtn }

        }
        editText.setText(valorDelBtn)
    }

    var operacion = "*"
    var numeroPrevio = ""
    var nuevaOperacion = true

    fun operaciones(view: View ){
        val btnCliqueado = view as Button
        when (btnCliqueado.id){
            btnDivision.id -> {
                operacion = "/"
            }
            btnMultiplicacion.id -> {
                operacion = "*"
            }
            btnResta.id -> {
                operacion = "-"
            }
            btnsuma.id -> {
                operacion = "+"
            }
        }

        numeroPrevio = editText.text.toString()
        nuevaOperacion = true
    }

    fun resultado (view: View){
        var nuevoNumero =  editText.text.toString()
        var numeroFinal : Double? = null

        when( operacion ){
            "*" -> numeroFinal = numeroPrevio.toDouble()  * nuevoNumero.toDouble()
            "/" -> numeroFinal =  numeroPrevio.toDouble() / nuevoNumero.toDouble()
            "+" -> numeroFinal =  numeroPrevio.toDouble() + nuevoNumero.toDouble()
            "-" -> numeroFinal =  numeroPrevio.toDouble() - nuevoNumero.toDouble()
        }

        editText.setText(numeroFinal.toString())
    }

    fun porcentaje(view: View){
        var numero:Double = editText.text.toString().toDouble() / 100
        editText.setText(numero.toString())
        nuevaOperacion = true
    }

    fun limpiar(view:View){
        editText.setText("0")
        nuevaOperacion = true
    }
}
