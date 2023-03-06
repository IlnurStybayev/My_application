package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_ninth.*
import kotlinx.android.synthetic.main.activity_tenth.*

class NinthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninth)

        val images = listOf(
            R.drawable.freeflowflava,
            R.drawable.primal,
            R.drawable.kaspiyskiy,
            R.drawable.kaspiy,
            R.drawable.redsun
        )
        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        btnBackNineActivity.setOnClickListener {
            finish()
        }
    }
}