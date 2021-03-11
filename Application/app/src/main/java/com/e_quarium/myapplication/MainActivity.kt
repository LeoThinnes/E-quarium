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

        //recupération des identifiants
        val boutonParametres = findViewById<Button>(R.id.boutonParametres)
        val boutonAquarium = findViewById<Button>(R.id.boutonAquarium)

        //changement d'activité suivant le bouton cliqué
        boutonParametres.setOnClickListener{
            val intent = Intent(this, MenuParametres::class.java)
            startActivity(intent)
        }

        boutonAquarium.setOnClickListener{
            val intent = Intent(this, MenuAquarium::class.java)
            startActivity(intent)
        }
    }

}