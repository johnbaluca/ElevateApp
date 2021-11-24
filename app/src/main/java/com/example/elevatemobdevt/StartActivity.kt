package com.example.elevatemobdevt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val button3 = findViewById<Button>(R.id.elevatenamebtn_startgame)

        /*button3.setOnClickListener {
            val Intent = Intent(this, MathQuizActivity::class.java)
            startActivity(Intent)
        } */
        button3.setOnClickListener {

            if (elevate_entername.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MathQuizActivity::class.java)
                intent.putExtra(Constants.USER_NAME, elevate_entername.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}