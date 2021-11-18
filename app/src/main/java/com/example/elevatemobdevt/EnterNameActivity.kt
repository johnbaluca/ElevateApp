package com.example.elevatemobdevt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EnterNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_name)

        val button3 = findViewById<Button>(R.id.elevatenamebtn_startgame)

        button3.setOnClickListener {
            val Intent = Intent(this, MathQuizActivity::class.java)
            startActivity(Intent)
        }
    }
}