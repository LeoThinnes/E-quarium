package com.e_quarium.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class affichage_temperature : AppCompatActivity() {
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

        var temp = findViewById<TextView>(R.id.temp)
<<<<<<< HEAD
        temp.setText("53")
    }  
=======
        temp.setText("24")
    }
>>>>>>> b1ddf2a41849e5ccc6990ad98b966085200f38d7


}