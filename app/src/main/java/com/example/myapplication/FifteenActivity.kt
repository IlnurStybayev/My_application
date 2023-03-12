package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fifteen.*

class FifteenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifteen)

        btnStartIntentService.setOnClickListener {
            try {
                Intent(this, MyIntentService::class.java).also{
                    startService(it)
                    tvIntentService.text = "Service running"
                }
            } catch (e: Exception) {
                // Handle the exception appropriately
                e.printStackTrace()
            }
        }
        btnStartMyService.setOnClickListener {
            try {
                Intent(this, MyService::class.java).also{
                    startService(it)
                    tvMyServiceStatus.text = "My Service running"
                }
            } catch (e: Exception) {
                // Handle the exception appropriately
                e.printStackTrace()
            }
        }

        btnStopIntentService.setOnClickListener {
            try {
                MyIntentService.stopService()
                tvIntentService.text = "Service stopped"
            } catch (e: Exception) {
                // Handle the exception appropriately
                e.printStackTrace()
            }
        }

        btnStopMyService.setOnClickListener {
            try {
                Intent(this, MyService::class.java).also{
                stopService(it)
                tvMyServiceStatus.text = "Service stopped"
                }
            }
            catch (e: Exception) {
                // Handle the exception appropriately
                e.printStackTrace()
            }
        }

        btnSendData.setOnClickListener {
            Intent(this, MyService::class.java).also{
                val dataString = etDataString.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }

        btnBack15.setOnClickListener {
            finish()
        }
    }
}
