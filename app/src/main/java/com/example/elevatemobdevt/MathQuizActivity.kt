package com.example.elevatemobdevt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_math_quiz.*


class MathQuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null

    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var elevate_lives: Int = 0

    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_quiz)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        setQuestion()


        elevate_optionone.setOnClickListener(this)
        elevate_optiontwo.setOnClickListener(this)
        elevate_optionthree.setOnClickListener(this)
        elevate_optionfour.setOnClickListener(this)
        elevatequizbtn_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.elevate_optionone -> {

                selectedOptionView(elevate_optionone, 1)
            }

            R.id.elevate_optiontwo -> {

                selectedOptionView(elevate_optiontwo, 2)
            }

            R.id.elevate_optionthree -> {

                selectedOptionView(elevate_optionthree, 3)
            }

            R.id.elevate_optionfour -> {

                selectedOptionView(elevate_optionfour, 4)
            }

            R.id.elevatequizbtn_submit -> {

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent =
                                Intent(this@MathQuizActivity, ScoreActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_answer)
                        elevate_lives++
                        var hearts = 3
                        hearts = hearts - elevate_lives
                        if(hearts>0) {
                            val view: View = findViewById(android.R.id.content)
                            Snackbar.make(view,
                                "You are wrong! You have $hearts chance/s left",
                                Snackbar.LENGTH_LONG)
                                .show()
                        }
                    }
                    else {
                        mCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_answer)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        elevatequizbtn_submit.text = "FINISH"
                    } else {
                        elevatequizbtn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                    return
                }
            }
        }
    }


    private fun setQuestion() {

        val question = mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            elevatequizbtn_submit.text = "FINISH"
        } else if(elevate_lives==3){
            Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            elevatequizbtn_submit.text = "SUBMIT"
        }

        elevate_progressbar.progress = mCurrentPosition
        elevate_progress.text = "$mCurrentPosition" + "/" + elevate_progressbar.getMax()

        elevate_question.text = question.question
        elevate_questionimg.setImageResource(question.image)
        elevate_optionone.text = question.optionOne
        elevate_optiontwo.text = question.optionTwo
        elevate_optionthree.text = question.optionThree
        elevate_optionfour.text = question.optionFour
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@MathQuizActivity,
            R.drawable.selected_option
        )
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, elevate_optionone)
        options.add(1, elevate_optiontwo)
        options.add(2, elevate_optionthree)
        options.add(3, elevate_optionfour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@MathQuizActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                elevate_optionone.background = ContextCompat.getDrawable(
                    this@MathQuizActivity,
                    drawableView
                )
            }
            2 -> {
                elevate_optiontwo.background = ContextCompat.getDrawable(
                    this@MathQuizActivity,
                    drawableView
                )
            }
            3 -> {
                elevate_optionthree.background = ContextCompat.getDrawable(
                    this@MathQuizActivity,
                    drawableView
                )
            }
            4 -> {
                elevate_optionfour.background = ContextCompat.getDrawable(
                    this@MathQuizActivity,
                    drawableView
                )
            }
        }
    }
}
