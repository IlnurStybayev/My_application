package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fifteen.*

class FifteenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifteen)

        btnStart15.setOnClickListener {
            try {
                Intent(this, MyIntentService::class.java).also{
                    startService(it)
                    tvServiceStopped.text = "Service running"
                }
            } catch (e: Exception) {
                // Handle the exception appropriately
                e.printStackTrace()
            }
        }

        btnStop15.setOnClickListener {
            try {
                MyIntentService.stopService()
                tvServiceStopped.text = "Service stopped"
            } catch (e: Exception) {
                // Handle the exception appropriately
                e.printStackTrace()
            }
        }

        btnBack15.setOnClickListener {
            finish()
        }
    }
}
