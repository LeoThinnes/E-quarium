package com.e_quarium.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PasEncoreFait : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pas_encore_fait)

        supportActionBar?.hide()

        //récupération des identifiants
        val boutonRetour = findViewById<Button>(R.id.boutonRetour)

        //retour
        boutonRetour.setOnClickListener{
            finish()
        }
    }
}