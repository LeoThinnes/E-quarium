package com.e_quarium.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class affichage_temperature : AppCompatActivity() {
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("temp")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affichage_temperature)

        supportActionBar?.hide()

        val btnRetourInfos = findViewById<Button>(R.id.btnRetourInfos)
        btnRetourInfos.setOnClickListener{
            val intent = Intent(this, MenuAquarium::class.java)
            finish()
        }

        val btnModifierParametres = findViewById<Button>(R.id.btnMofifierParamètres)
        btnModifierParametres.setOnClickListener{
            val intent = Intent(this, ParametreTemperature::class.java)
            startActivity(intent)
        }

        val temperature = findViewById<TextView>(R.id.temp)
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = data.getValue().toString()
                temperature.setText(value)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })

    }



}

