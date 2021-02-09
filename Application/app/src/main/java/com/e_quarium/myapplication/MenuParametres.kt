package com.e_quarium.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuParametres : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_parametres)

        supportActionBar?.hide()

        val btnRetour = findViewById<Button>(R.id.btnRetourPasFait)
        btnRetour.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }

        val btnInfoTemp = findViewById<Button>(R.id.btnInfosTemp)
        btnInfoTemp.setOnClickListener{
            val intent = Intent(this, ParametreTemperature::class.java)
            startActivity(intent)
        }

        val btnParametreLumiere = findViewById<Button>(R.id.btnInfoLumiere)
        btnParametreLumiere.setOnClickListener {
            val intent = Intent(this, PasEncoreFait::class.java)
            startActivity(intent)
        }

        val btnNourriture = findViewById<Button>(R.id.btnParametreNourriture)
        btnNourriture.setOnClickListener {
            val intent = Intent(this, PasEncoreFait::class.java)
            startActivity(intent)
        }
    }

    fun envoieDonnées(view: View) {}
    fun envoieDonnees(view: View) {}
}