package com.cead.androidtres

class Coche{
        var imagen: Int? = null
        var titulo: String?  = null
        var descripcion : String? = null
        var precio: Int? = null
        var venta: Boolean? = null

        constructor(imagen:Int, titulo:String, descripcion:String, precio:Int, venta:Boolean){

            this.imagen = imagen
            this.titulo = titulo
            this.descripcion = descripcion
            this.precio = precio
            this.venta = venta
        }
 }