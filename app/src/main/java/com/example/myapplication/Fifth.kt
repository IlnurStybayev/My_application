package com.example.myapplication

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fifth.*

class Fifth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        btnOrder.setOnClickListener {
            val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked
            val salad = cbSalad.isChecked
            val orderString = "You ordered burger:\n" +
                    "${meat.text}" +
                    (if (cheese) "\nCheese" else "" ) +
                    (if (onions) "\nOnions" else "") +
                    (if (salad) "\nSalad" else "")
            tvOrder.text = orderString
        }
        btnClean.setOnClickListener {
            tvOrder.text = ""
            cbCheese.isChecked = false
            cbOnions.isChecked = false
            cbSalad.isChecked = false
        }
        btnBack5.setOnClickListener {
            finish()
        }
    }
}