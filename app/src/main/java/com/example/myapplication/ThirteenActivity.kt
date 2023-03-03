package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_thirteen.*
import kotlinx.android.synthetic.main.activity_twelfth.*

class ThirteenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thirteen)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }
        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
                addToBackStack(null)
            commit()
             }
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
        btnBack13.setOnClickListener {
            finish()
        }

    }
}