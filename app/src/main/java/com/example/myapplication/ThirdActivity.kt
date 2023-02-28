package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        btnAddImage.setOnClickListener {
            ivImageView.setImageResource(R.drawable.redsun)
        }
        btnDeleteImage.setOnClickListener {
            ivImageView.setImageResource(0)
        }
        btnBack3.setOnClickListener {
            finish()
        }
    }
}