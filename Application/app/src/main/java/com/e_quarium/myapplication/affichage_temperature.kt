package com.e_quarium.myapplication

import android.content.Intent
import android.graphics.Color
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
    var myRef = database.getReference("ParamTemp")


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
        val txtTemp = findViewById<TextView>(R.id.txtTemp)
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var ecart = data.child("ecart").getValue().toString()
                var ecartInt = ecart.toFloat()
                var TempVoul = data.child("tempVoulue").getValue().toString()
                var TempVoulInt = TempVoul.toFloat()
                var TempAct = data.child("tempActuelle").getValue().toString()
                var TempActInt = TempAct.toFloat()

                temperature.setText(TempAct)

                if ((TempActInt <= (TempVoulInt + ecartInt)) && (TempActInt >= (TempVoulInt - ecartInt))){
                    txtTemp.setText("l'eau est à une bonne température")
                    txtTemp.setTextColor(Color.parseColor("#FFFFFF"))
                } else if (TempActInt > (TempVoulInt + ecartInt)){
                    txtTemp.setText("l'eau est trop chaude")
                    txtTemp.setTextColor(Color.parseColor("#DC2700"))
                }else if (TempActInt < (TempVoulInt - ecartInt)){
                    txtTemp.setText("l'eau est trop froide")
                    txtTemp.setTextColor(Color.parseColor("#DC2700"))
                }

            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })

    }
}

