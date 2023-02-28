package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0)
            tvCount.text = "Lets count together:$count"
        }

        btnCount.setOnClickListener{
            count++
            tvCount.text = "Lets count together:$count"
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }
}
