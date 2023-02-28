package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_seventh.*

class SeventhActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seventh)

        // Disable buttons initially
        btnApply7.isEnabled = false
        btnClean7.isEnabled = false

        // Add text change listener to all EditTexts
        etName.addTextChangedListener(textWatcher)
        etAge.addTextChangedListener(textWatcher)
        etCountry.addTextChangedListener(textWatcher)

        btnApply7.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val country = etCountry.text.toString()
            val person = Person(name, age, country)
            Intent(this, EighthActivity::class.java).also {
                it.putExtra("EXTRA_PERSON", person)
                startActivity(it)
            }
        }
        btnBack7.setOnClickListener {
            finish()
        }

        // Set click listener for Clear button
        btnClean7.setOnClickListener {
            etName.setText("")
            etAge.setText("")
            etCountry.setText("")
            btnApply7.isEnabled = false
            btnClean7.isEnabled = false
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val name = etName.text.toString()
            val age = etAge.text.toString()
            val country = etCountry.text.toString()

            // Enable Clear button if at least one EditText has text
            btnClean7.isEnabled = name.isNotEmpty() || age.isNotEmpty() || country.isNotEmpty()

            // Enable Apply button if all EditTexts have text
            btnApply7.isEnabled = name.isNotEmpty() && age.isNotEmpty() && country.isNotEmpty()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }
}
