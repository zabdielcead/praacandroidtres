package com.cead.androidtres

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.github.johnpersano.supertoasts.library.Style
import com.github.johnpersano.supertoasts.library.SuperActivityToast
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils
import kotlinx.android.synthetic.main.activity_four.*

class FourActivity : AppCompatActivity() {

    var jugador1 = ArrayList<Int>()
    var jugador2 = ArrayList<Int>()
    var jugadorActivo = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)


        btnLisviewAct.setOnClickListener{
            var intent = Intent(this@FourActivity, FiveActivity:: class.java)
            this.startActivity(intent)
        }

    }

    protected fun btnClickGato(view: View){
        val btnSeleccionado = view as Button
        var idCelda = 0

        when(btnSeleccionado.id){
            R.id.btntab1 -> idCelda = 1
            R.id.btntab2 -> idCelda = 2
            R.id.btntab3 -> idCelda = 3
            R.id.btntab4 -> idCelda = 4
            R.id.btntab5 -> idCelda = 5
            R.id.btntab6 -> idCelda = 6
            R.id.btntab7 -> idCelda = 7
            R.id.btntab8 -> idCelda = 8
            R.id.btntab9 -> idCelda = 9

        }

        partida(idCelda, btnSeleccionado)
    }

    fun partida(idCelda:Int, btnSeleccionado: Button){
        if(jugadorActivo == 1){
            btnSeleccionado.text = "X"
            btnSeleccionado.setBackgroundColor(Color.BLUE)
            jugador1.add(idCelda)
            jugadorActivo = 2
        }else{
            btnSeleccionado.text = "O"
            btnSeleccionado.setBackgroundColor(Color.GREEN)
            jugador2.add(idCelda)
            jugadorActivo = 1
        }
        btnSeleccionado.isEnabled = false

        ganador()
    }


    fun ganador(){
        var ganador = -1
        // linea 1
        if(jugador1.contains(1)  && jugador1.contains(2) && jugador1.contains(3)){
            ganador = 1
        }

        if(jugador2.contains(1)  && jugador2.contains(2) && jugador2.contains(3)){
            ganador = 2
        }

        //linea 2
        if(jugador1.contains(4)  && jugador1.contains(5) && jugador1.contains(6)){
            ganador = 1
        }

        if(jugador2.contains(4)  && jugador2.contains(5) && jugador2.contains(6)){
            ganador = 2
        }
        //linea 3
        if(jugador1.contains(7)  && jugador1.contains(8) && jugador1.contains(9)){
            ganador = 1
        }

        if(jugador2.contains(7)  && jugador2.contains(8) && jugador2.contains(9)){
            ganador = 2
        }

        //columna 1
        if(jugador1.contains(1)  && jugador1.contains(4) && jugador1.contains(7)){
            ganador = 1
        }
        if(jugador2.contains(1)  && jugador2.contains(4) && jugador2.contains(7)){
            ganador = 2
        }

        //columna 2
        if(jugador1.contains(2)  && jugador1.contains(5) && jugador1.contains(8)){
            ganador = 1
        }
        if(jugador2.contains(2)  && jugador2.contains(5) && jugador2.contains(8)){
            ganador = 2
        }

        //columna 3
        if(jugador1.contains(3)  && jugador1.contains(6) && jugador1.contains(9)){
            ganador = 1
        }
        if(jugador2.contains(3)  && jugador2.contains(6) && jugador2.contains(9)){
            ganador = 2
        }


        //linea x 1
        if(jugador1.contains(1)  && jugador1.contains(5) && jugador1.contains(9)){
            ganador = 1
        }
        if(jugador2.contains(1)  && jugador2.contains(5) && jugador2.contains(9)){
            ganador = 2
        }


        //linea x 2
        if(jugador1.contains(3)  && jugador1.contains(5) && jugador1.contains(7)){
            ganador = 1
        }
        if(jugador2.contains(3)  && jugador2.contains(5) && jugador2.contains(7)){
            ganador = 2
        }


        if(ganador == 1){
           // Toast.makeText(this, "jugador Uno ha ganado! XD", Toast.LENGTH_LONG).show()
            val superActivityToast  = SuperActivityToast(this)
            superActivityToast.text = "jugador Uno ha ganado! XD"
            superActivityToast.duration = Style.DURATION_LONG
            superActivityToast.color = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_CYAN)
            superActivityToast.textColor = Color.DKGRAY
            superActivityToast.setTouchToDismiss(true)
            superActivityToast.isIndeterminate = true
            superActivityToast.progressIndeterminate = true
            superActivityToast.show()
        }



        if(ganador == 2){
            // Toast.makeText(this, "jugador Dos ha ganado! XD", Toast.LENGTH_LONG).show()
            val superActivityToast  = SuperActivityToast(this)
            superActivityToast.text = "jugador Dos ha ganado! XD"
            superActivityToast.duration = Style.DURATION_LONG
            superActivityToast.color = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_CYAN)
            superActivityToast.textColor = Color.DKGRAY
            superActivityToast.setTouchToDismiss(true)
            superActivityToast.isIndeterminate = true
            superActivityToast.progressIndeterminate = true
            superActivityToast.show()
        }


    }

}
