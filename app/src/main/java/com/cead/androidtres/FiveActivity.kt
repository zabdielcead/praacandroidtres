package com.cead.androidtres

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_five.*
import kotlinx.android.synthetic.main.molde_coche.view.*

class FiveActivity(var adapter: CochesAdapter? = null) : AppCompatActivity() {

    var listaCoches  =  ArrayList<Coche>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)
        listaCoches.add(Coche(R.drawable.hw_bowser_sm, "Coche Bowser" , "Coche del malvado Bowser" , 350, false))
        listaCoches.add(Coche(R.drawable.hw_buddy_car, "Coche Buddy" , "Coche de Buddy" , 250, true))
        listaCoches.add(Coche(R.drawable.hw_camaro_ee_2015, "Coche Camaro" , "Coche del camaro" , 310, false))
        listaCoches.add(Coche(R.drawable.hw_charger_2014, "Coche charger" , "Coche del charger" , 320, true))
        listaCoches.add(Coche(R.drawable.hw_fury_shark, "Coche Shark" , "Coche del Shark" , 450, false))
        listaCoches.add(Coche(R.drawable.hw_mario_sm, "Coche Mario" , "Coche del Mario" , 650, true))
        listaCoches.add(Coche(R.drawable.hw_toad_sm, "Coche Toad" , "Coche del Toad" , 150, false))
        listaCoches.add(Coche(R.drawable.hw_yoshi_sm, "Coche Yoshi" , "Coche del Yoshi" , 220, true))

        adapter = CochesAdapter(this, listaCoches)


        listView.adapter = adapter
    }




    class CochesAdapter(contexto: Context, var listaDeCoches: ArrayList<Coche>): BaseAdapter() {

        var context: Context? = contexto

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val coche = listaDeCoches[position]
            if(coche.venta == true) {
                val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val miVista = inflater.inflate(R.layout.molde_coche, null)
                miVista.txAutoTit.text = coche.titulo!!
                miVista.txAutoDesc.text = coche.descripcion!!
                miVista.txAutoPrecio.text = coche.precio!!.toString()
                miVista.imgAuto.setImageResource(coche.imagen!!)
                miVista.imgAuto.setOnClickListener {
                    var intent = Intent(context, CocheActivity::class.java)
                    intent.putExtra("imagen", coche.imagen!!)
                    intent.putExtra("titulo", coche.titulo!!)
                    intent.putExtra("descripcion", coche.descripcion!!)
                    intent.putExtra("precio", coche.precio!!)

                    context!!.startActivity(intent)
                }

                return miVista
            }else{
                val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val miVista = inflater.inflate(R.layout.molde_venta, null)
                miVista.txAutoTit.text = coche.titulo!!
                miVista.txAutoDesc.text = coche.descripcion!!
                miVista.txAutoPrecio.text = coche.precio!!.toString()
                miVista.imgAuto.setImageResource(coche.imagen!!)
                miVista.imgAuto.setOnClickListener {
                    var intent = Intent(context, VentaActivity::class.java)
                    intent.putExtra("imagen", coche.imagen!!)
                    intent.putExtra("titulo", coche.titulo!!)
                    intent.putExtra("descripcion", coche.descripcion!!)
                    intent.putExtra("precio", coche.precio!!)

                    context!!.startActivity(intent)
                }
                return miVista
            }


        }

        override fun getItem(position: Int): Any {
          return listaDeCoches[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listaDeCoches.size
        }

    }
}
