package com.e_quarium.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuAquarium : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_aquarium)

        supportActionBar?.hide()

        val btnRetour = findViewById<Button>(R.id.btnRetour)
        btnRetour.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnAffichage = findViewById<Button>(R.id.btnInfosTemp)
        btnAffichage.setOnClickListener {
            val intent = Intent(this, Affichage_temperature::class.java)
            startActivity(intent)
        }
    }
}