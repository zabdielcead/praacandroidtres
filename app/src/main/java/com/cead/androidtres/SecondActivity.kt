package com.cead.androidtres

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnCentro.setOnClickListener{
            var intent = Intent(this@SecondActivity, ThirdActivity:: class.java)
            this.startActivity(intent)
        }
    }
}
