package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btnApply = findViewById<Button>(R.id.btnApply)

        btnApply.setOnClickListener {

            val firstName = findViewById<EditText>(R.id.etFirstName).text.toString()
            val lastName = findViewById<EditText>(R.id.etLastName).text.toString()
            val birthDay = findViewById<EditText>(R.id.etBirthDay).text.toString()
            val country = findViewById<EditText>(R.id.etCountry).text.toString()
            val date = "${firstName.toString()}\n" + "${lastName.toString()}\n"+ "${birthDay.toString()}\n"+ "${country.toString()}\n"
            tvResult.text = date
            Log.d("MainActivity", "$firstName $lastName, born on $birthDay , from $country just applied to the formular")
        }
        btnBack2.setOnClickListener {
            finish()
        }
    }
}