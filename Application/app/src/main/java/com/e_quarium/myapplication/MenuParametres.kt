package com.e_quarium.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuParametres : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_parametres)

        supportActionBar?.hide()

        //recupération des identifiants
        val boutonRetour = findViewById<Button>(R.id.boutonRetour)
        val boutonParametresTemperature = findViewById<Button>(R.id.boutonParametresTemperature)
        val boutonParametresLumiere = findViewById<Button>(R.id.boutonParametresLumiere)
        val boutonParametresNourriture = findViewById<Button>(R.id.boutonParametresNourriture)


        //retour
        boutonRetour.setOnClickListener{
            finish()
        }

        //changement d'activité au click
        boutonParametresTemperature.setOnClickListener{
            val intent = Intent(this, ParametreTemperature::class.java)
            startActivity(intent)
        }

        boutonParametresLumiere.setOnClickListener {
            val intent = Intent(this, PasEncoreFait::class.java)
            startActivity(intent)
        }

        boutonParametresNourriture.setOnClickListener {
            val intent = Intent(this, PasEncoreFait::class.java)
            startActivity(intent)
        }
    }

}