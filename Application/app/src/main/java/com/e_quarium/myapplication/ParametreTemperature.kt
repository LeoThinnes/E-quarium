package com.e_quarium.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class ParametreTemperature : AppCompatActivity() {

    //connexion a la base de données
    var database = FirebaseDatabase.getInstance()
    var donnees = database.getReference("ParamTemp")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parametre_temperature)

        supportActionBar?.hide()

        //recupération des identifiants
        val boutonRetour = findViewById<Button>(R.id.boutonRetour)
        val boutonValider = findViewById<Button>(R.id.boutonValider)
        val temperatureMoyenneVoulue = findViewById<EditText>(R.id.temperatureMoyenneVoulue)
        val ecartTemperature = findViewById<EditText>(R.id.ecartTemperature)



        boutonRetour.setOnClickListener{
            finish()
        }

        boutonValider.setOnClickListener{
            var textTemperatureMoyenne = temperatureMoyenneVoulue.text.toString()
            var textEcartTemperature = ecartTemperature.text.toString()
            donnees.child("tempVoulue").setValue(textTemperatureMoyenne)
            donnees.child("ecart").setValue(textEcartTemperature)
        }

    }


}

