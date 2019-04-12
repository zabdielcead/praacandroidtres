package com.cead.androidtres

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        btnTercera.setOnClickListener{
            var intent = Intent(this@ThirdActivity, FourActivity:: class.java)
            this.startActivity(intent)
        }


        button3.setOnClickListener{
            var intent = Intent(this@ThirdActivity, SixActivity:: class.java)
            this.startActivity(intent)
        }
    }

}
