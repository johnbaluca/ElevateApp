package com.example.elevatemobdevt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_score.*
import java.util.*


class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constants.USER_NAME)
        elevate_resultname.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)


        if(totalQuestions == 10) {
            elevate_score.text = "Your Score is $correctAnswers out of $totalQuestions."
        }

        elevatescorebtn_finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        itemShare.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Elevate App Quiz Game:" +
                        "\nYou got a score of ${getCorrectAnswers().toString()} out of 10" +
                        "\non ${Calendar.getInstance().time}")
                type = "text/plain"
            }
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_game, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.itemShare){
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Elevate App Quiz Game:" +
                "\nYou got a score of ${getCorrectAnswers().toString()} out of 10" +
                "\non ${Calendar.getInstance().time}")
                type = "text/plain"
            }
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getCorrectAnswers(): Int{
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        return correctAnswers
    }

}