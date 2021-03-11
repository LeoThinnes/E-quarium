package com.e_quarium.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class affichage_temperature : AppCompatActivity() {

    //connexion a la base de données
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("ParamTemp")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affichage_temperature)

        //suppression de la barre en haut de l'écran
        supportActionBar?.hide()

        //recupération des identifiants des objets de l'activité
        val boutonRetourInfos = findViewById<Button>(R.id.boutonRetourInfos)
        val boutonModifierParametres = findViewById<Button>(R.id.boutonMofifierParametres)
        val temperature = findViewById<TextView>(R.id.temperature)
        val informationTemperature = findViewById<TextView>(R.id.informationTemperature)
        val imageThermometre = findViewById<ImageView>(R.id.imageThermometre)
        val imageDecors = findViewById<ImageView>(R.id.imageDecors)


        boutonRetourInfos.setOnClickListener{
            finish()
        }

        boutonModifierParametres.setOnClickListener{
            val intent = Intent(this, ParametreTemperature::class.java)
            startActivity(intent)
        }

        //recuperation des données de la base de données
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                var ecart = data.child("ecart").getValue().toString()
                var ecartInt = ecart.toFloat()
                var TempVoul = data.child("tempVoulue").getValue().toString()
                var TempVoulInt = TempVoul.toFloat()
                var TempAct = data.child("tempActuelle").getValue().toString()
                var TempActInt = TempAct.toFloat()

                //Affichage de la température
                temperature.setText(TempAct)

                //Mise en place des différents affichage suivant la température
                if ((TempActInt <= (TempVoulInt + ecartInt)) && (TempActInt >= (TempVoulInt - ecartInt))) {
                    informationTemperature.setText("l'eau est à une bonne température")
                    informationTemperature.setTextColor(Color.parseColor("#FFFFFF"))
                    imageThermometre.setImageResource(R.drawable.normal)
                    imageDecors.setImageResource(R.drawable.soleil)
                } else if (TempActInt > (TempVoulInt + ecartInt)) {
                    informationTemperature.setText("l'eau est trop chaude")
                    informationTemperature.setTextColor(Color.parseColor("#DC2700"))
                    imageThermometre.setImageResource(R.drawable.chaud)
                    imageDecors.setImageResource(R.drawable.flamme)
                } else if (TempActInt < (TempVoulInt - ecartInt)) {
                    informationTemperature.setText("l'eau est trop froide")
                    informationTemperature.setTextColor(Color.parseColor("#DC2700"))
                    imageThermometre.setImageResource(R.drawable.froid)
                    imageDecors.setImageResource(R.drawable.flocon)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })

    }
}

