package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            fun calculateBMI(){

                val weight = findViewById<EditText>(R.id.inputWeight).text
                val height = findViewById<EditText>(R.id.inputHeight).text
                val showUserBMI = findViewById<TextView>(R.id.textBMI)
                val classification = findViewById<TextView>(R.id.textClassification)

                if(weight.isNullOrEmpty() || height.isNullOrEmpty()){
                    Toast.makeText(this@MainActivity, "Por favor digite um valor válido.", Toast.LENGTH_SHORT).show()
                }else{
                    if (height.toString().toFloat() > 2.51F){Toast.makeText(this@MainActivity, "Parece que você digitou a altura sem ponto entre o valor de metros e centímetros, isso causará erro no cálculo, tente algo como: (1.70).", Toast.LENGTH_LONG).show()}
                    val calculatedBMI = (weight.toString().toFloat()/(height.toString().toFloat()*height.toString().toFloat()))

                    if(calculatedBMI < 16){
                        showUserBMI.text = calculatedBMI.toString()
                        classification.text = "Magreza grave"}
                    if(calculatedBMI in (16F..16.9F)){
                        showUserBMI.text = calculatedBMI.toString()
                        classification.text = "Magreza moderada"}
                    if(calculatedBMI in (17F..18.50F)){
                        showUserBMI.text = calculatedBMI.toString()
                        classification.text = "Magreza leve"}
                    if(calculatedBMI in (18.51F..25F)){
                        showUserBMI.text = calculatedBMI.toString()
                        classification.text = "Saudável"}
                    if(calculatedBMI in (25.01F..30F)){
                        showUserBMI.text = calculatedBMI.toString()
                        classification.text = "Sobrepeso"}
                    if(calculatedBMI in (30.01F..35F)){
                        showUserBMI.text = calculatedBMI.toString()
                        classification.text = "Obesidade Grau I"}
                    if(calculatedBMI in (35.01F..40F)){
                        showUserBMI.text = calculatedBMI.toString()
                        classification.text = "Obesidade Grau II (severa)"}
                    if(calculatedBMI > 40.01F){
                        showUserBMI.text = calculatedBMI.toString()
                        classification.text = "Obesidade Grau III (mórbida)"}

                }
            }

            val button = findViewById<Button>(R.id.buttonCalculate)
            button.setOnClickListener { calculateBMI() }
    }
}
