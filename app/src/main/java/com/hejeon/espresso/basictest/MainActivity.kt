package com.hejeon.espresso.basictest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hejeon.espresso.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        next_activity.setOnClickListener {
            startActivity(Intent(this@MainActivity,
                SecondActivity::class.java))
        }
    }
}
