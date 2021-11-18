package com.example.elevatemobdevt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val button1 = findViewById<Button>(R.id.elevatemainbtn_start)
        val button2 = findViewById<Button>(R.id.elevatemainbtn_aboutus)

        button1.setOnClickListener {
            val Intent = Intent (this,EnterNameActivity::class.java )
            startActivity(Intent)
        }

        button2.setOnClickListener {
            val Intent = Intent (this,AboutUsActivity::class.java )
            startActivity(Intent)
        }

    }
}