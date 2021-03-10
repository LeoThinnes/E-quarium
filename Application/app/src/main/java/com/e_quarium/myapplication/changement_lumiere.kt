package com.e_quarium.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase

class changement_lumiere : AppCompatActivity() {
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("Lumiere")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changement_lumiere)

        supportActionBar?.hide()

        val btnJaune = findViewById<Button>(R.id.btnLumJaune)
        val btnRouge = findViewById<Button>(R.id.btnLumBleu)
        val btnOff = findViewById<Button>(R.id.btnLumOff)
        val btnRetour = findViewById<Button>(R.id.btnRetour)

        btnJaune.setOnClickListener {
            myRef.setValue(1)
        }

        btnRouge.setOnClickListener {
            myRef.setValue(2)
        }

        btnOff.setOnClickListener {
            myRef.setValue(0)
        }

        btnRetour.setOnClickListener {
            finish()
        }
    }
}