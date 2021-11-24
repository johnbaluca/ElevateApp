package com.example.elevatemobdevt

import com.example.elevatemobdevt.R
import com.example.elevatemobdevt.Question

object Constants {

    // START
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    // END

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1, "Question 1",
            R.drawable.question2,//Flashcard 2 - what is the formula for length in a rectangle
            "(P/2) - w", "2 × π × r",
            "π × r2", "P × w", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "Question 2",
            R.drawable.question3,// Flash Card 3 what is 10 inches in cm
            "23.3 cm", "26.4 cm",
            "25.4 cm", "23.8 cm", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "Question 3",
            R.drawable.question4,//Flash card 4 What is the diameter of a circle with radius of 5 inches
            "11 inches", "12 inches",
            "8 inches", "10 inches", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "Question 4",
            R.drawable.question8,//Flash card 8 Which is Greater than 4
            "3", "5",
            "-5", "3.5", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "Question 5",
            R.drawable.question9,//Flash card 9 Which is the smallest
            "3", "4",
            "-1", "2", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "Question 6",
            R.drawable.question1,
            "(x-3)(x-3)", "(x-3)^2",
            "(x-3)(3y-2)", "3y(x-3)", 3
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "Question 7",
            R.drawable.question5,
            "4", "40",
            "10", "1", 1
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "Question 8",
            R.drawable.question6,
            "x^2+20x-20", "x^2-x-20",
            "x^2+9x-20", "x^2+x-20", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "Question 9",
            R.drawable.question7,
            "-2(x-4)(x+5)", "5(x-4)(x+1)",
            "-5(x+4)(x-1)", "5(x+4)(x+1)", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Question 10",
            R.drawable.question10,
            "-26", "26",
            "0", "1", 2
        )

        questionsList.add(que10)

        return questionsList
    }
}