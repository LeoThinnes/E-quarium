package com.e_quarium.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Affichage_temperature : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affichage_temperature)

        supportActionBar?.hide()

        val btnRetourInfos = findViewById<Button>(R.id.btnRetourInfos)
        btnRetourInfos.setOnClickListener{
            val intent = Intent(this, MenuAquarium::class.java)
            startActivity(intent)
        }
    }
}