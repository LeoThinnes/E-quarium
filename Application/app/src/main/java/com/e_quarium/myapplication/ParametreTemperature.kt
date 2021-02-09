package com.e_quarium.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class ParametreTemperature : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parametre_temperature)
        var database = FirebaseDatabase.getInstance()
        var myRef = database.getReference("test")

        myRef.setValue(22)

        supportActionBar?.hide()

        val btnRetour = findViewById<Button>(R.id.btnRetourPasFait)
        btnRetour.setOnClickListener{
            finish()
        }

        val editText:String? = findViewById<EditText>(R.id.editTextNumber).toString()

        val btnValider = findViewById<Button>(R.id.btnValider)



       

    }






}