package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_fourteenth.*

class FourteenthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourteenth)

        val sharePref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharePref.edit()
        btnSave.setOnClickListener {
            val name = etName14.text.toString()
            val ageStr = etAge14.text.toString()
            var age = 0

            if (ageStr.isNotBlank()) {
                try {
                    age = ageStr.toInt()
                } catch (e: NumberFormatException) {
                    // Handle the exception as appropriate
                    Log.e("FourteenthActivity", "Error converting age to integer: ${e.message}")
                    return@setOnClickListener
                }
            }

            val isAdult = cbAdult.isChecked

            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }
        btnLoad.setOnClickListener {
            val name = sharePref.getString("name", null)
            val age = sharePref.getInt("age", 0)
            val isAdult = sharePref.getBoolean("isAdult", false)
            etName14.setText(name)
            etAge14.setText(age.toString())
            cbAdult.isChecked =isAdult
        }
        btnBack14.setOnClickListener {
            finish()
        }
    }
}