package main

import questions.DiagonalDifference
import questions.MinMaxSum
import questions.Question

object QuestionsBank {
    var questions: ArrayList<Question> = arrayListOf()

    init {
        questions = arrayListOf(
            DiagonalDifference(),
            MinMaxSum()
        )
    }
}