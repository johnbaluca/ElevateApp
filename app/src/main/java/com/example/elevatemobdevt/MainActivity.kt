package com.example.elevatemobdevt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import com.example.elevatemobdevt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        //val button1 = findViewById<Button>(R.id.elevatemainbtn_start)
        //val button2 = findViewById<Button>(R.id.elevatemainbtn_aboutus)

        binding.elevatemainbtnStart.setOnClickListener {
            val intent = Intent (this,StartActivity::class.java )
            startActivity(intent)
        }
        binding.elevatemainbtnAboutus.setOnClickListener {
            val intent = Intent (this,AboutUsActivity::class.java )
            startActivity(intent)
        }

    }
}