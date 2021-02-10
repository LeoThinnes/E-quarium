package com.e_quarium.myapplication

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener




class ParametreTemperature : AppCompatActivity() {

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("test2")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parametre_temperature)


        supportActionBar?.hide()

        val btnRetour = findViewById<Button>(R.id.btnRetourPasFait)
        btnRetour.setOnClickListener{
            finish()
        }

        val editText:String? = findViewById<EditText>(R.id.editTextNumber).toString()

        val btnValider = findViewById<Button>(R.id.btnValider)
        btnValider.setOnClickListener{
            myRef.setValue(23)
        }

    }


}