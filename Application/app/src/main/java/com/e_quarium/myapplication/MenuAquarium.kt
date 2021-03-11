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

        //recupération des identifiants
        val boutonRetour = findViewById<Button>(R.id.boutonRetour)
        val boutonAffichageTemperature = findViewById<Button>(R.id.boutonParametresTemperature)
        val boutonEclairage = findViewById<Button>(R.id.boutonParametresLumiere)
        val boutonNourriture = findViewById<Button>(R.id.boutonParametresNourriture)

        //fermeture de l'activité au click (retour)
        boutonRetour.setOnClickListener{
            finish()
        }

        //changement d'activité suivant le bouton cliqué
        boutonAffichageTemperature.setOnClickListener {
            val intent = Intent(this, affichage_temperature::class.java)
            startActivity(intent)
        }

        boutonEclairage.setOnClickListener {
            val intent = Intent(this, changement_lumiere::class.java)
            startActivity(intent)
        }

        boutonNourriture.setOnClickListener {
            val intent = Intent(this, PasEncoreFait::class.java)
            startActivity(intent)
        }
    }
}