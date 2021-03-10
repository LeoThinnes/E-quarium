package com.e_quarium.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class ParametreTemperature : AppCompatActivity() {

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("ParamTemp")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parametre_temperature)


        supportActionBar?.hide()

        val btnRetour = findViewById<Button>(R.id.btnRetour)
        btnRetour.setOnClickListener{
            finish()
        }



        val btnValider = findViewById<Button>(R.id.btnValider)
        btnValider.setOnClickListener{
            val tempMoy = findViewById<EditText>(R.id.editTextNumber)
            var temperatureMoyenne = tempMoy.text.toString()
            val ecart = findViewById<EditText>(R.id.editTextNumber2)
            var ecarTemp = ecart.text.toString()
            myRef.child("tempVoulue").setValue(temperatureMoyenne)
            myRef.child("ecart").setValue(ecarTemp)
        }

    }


}

