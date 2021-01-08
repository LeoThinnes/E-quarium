package com.e_quarium.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val btnParametres = findViewById<Button>(R.id.btnParametres)
        btnParametres.setOnClickListener{
            val intent = Intent(this, MenuParametres::class.java)
            startActivity(intent)
        }

        val btnAquarium = findViewById<Button>(R.id.btnAquarium)
        btnAquarium.setOnClickListener{
            val intent = Intent(this, MenuAquarium::class.java)
            startActivity(intent)
        }
    }

}