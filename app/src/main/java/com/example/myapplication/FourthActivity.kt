package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_fourth.*


class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        btnAdd4.isEnabled = false
        btnClean4.isEnabled = false

        etFirstNumber.addTextChangedListener {
            updateButtonState()
        }
        etSecondNumber.addTextChangedListener {
            updateButtonState()
        }

        btnAdd4.setOnClickListener {
            calculateResult()
        }

        btnClean4.setOnClickListener {
            cleanResult()
        }

        btnBack4.setOnClickListener {
            finish()
        }
    }

    private fun updateButtonState() {
        val firstNumberStr = etFirstNumber.text.toString()
        val secondNumberStr = etSecondNumber.text.toString()
        val isNotEmpty = firstNumberStr.isNotEmpty() || secondNumberStr.isNotEmpty()
        btnAdd4.isEnabled = isNotEmpty && firstNumberStr.toDoubleOrNull() != null && secondNumberStr.toDoubleOrNull() != null
        btnClean4.isEnabled = isNotEmpty
    }

    private fun calculateResult() {
        val firstNumberStr = etFirstNumber.text.toString()
        val secondNumberStr = etSecondNumber.text.toString()

        val firstNumber = firstNumberStr.toDoubleOrNull()
        val secondNumber = secondNumberStr.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = firstNumber + secondNumber
            tvResult.text = result.toString()
        }
    }

    private fun cleanResult() {
        tvResult.text = ""
        etFirstNumber.text.clear()
        etSecondNumber.text.clear()
        btnAdd4.isEnabled = false
        btnClean4.isEnabled = false
    }
}



