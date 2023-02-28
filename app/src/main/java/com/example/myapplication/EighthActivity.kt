package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_eighth.*
import kotlinx.android.synthetic.main.activity_sixth.*

@Suppress("DEPRECATION")
class EighthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eighth)
        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        tvPerson8.text = person.toString()
        btnBack8.setOnClickListener {
            finish()
        }
    }

}