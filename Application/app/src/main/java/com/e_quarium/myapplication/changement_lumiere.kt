package com.e_quarium.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase

class changement_lumiere : AppCompatActivity() {

    //connexion a la base de données
    var database = FirebaseDatabase.getInstance()
    var donnees = database.getReference("Lumiere")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changement_lumiere)

        supportActionBar?.hide()

        //recupération des identifiants
        val boutonLumiereJaune = findViewById<Button>(R.id.boutonLumiereJaune)
        val boutonLumiereRouge = findViewById<Button>(R.id.boutonLumiereRouge)
        val boutonEteindreLumiere = findViewById<Button>(R.id.boutonEteindreLumiere)
        val boutonRetour = findViewById<Button>(R.id.boutonRetour)

        //envoie d'une valeur sur la base de données suivant le bouton cliqué
        boutonLumiereJaune.setOnClickListener {
            donnees.setValue(1)
        }

        boutonLumiereRouge.setOnClickListener {
            donnees.setValue(2)
        }

        boutonEteindreLumiere.setOnClickListener {
            donnees.setValue(0)
        }

        //bouton de retour
        boutonRetour.setOnClickListener {
            finish()
        }
    }
}