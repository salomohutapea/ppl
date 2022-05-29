package main

import questions.QuestionsBank

fun main() {
    Main(QuestionsBank()).init()
}

class Main(
    val qb: QuestionsBank,
) {
    fun init() {
        printListOfQuestions()
        enterQuestionNo()
    }

    fun printListOfQuestions() {
        if (qb.questions.isNotEmpty()) {
            println("List of Questions: ")

            qb.questions.forEachIndexed { i, q ->
                println("[${i + 1}] ${q.questionName}")
            }
        }
    }

    private fun enterQuestionNo() {
        println("\nEnter question number or [x] to exit this program:")

        val questionNo: String = readLine()!!

        validateQuestionNoInput(questionNo)
    }

    fun validateQuestionNoInput(questionNo: String) {
        if (qb.questions.isNotEmpty()) {
            if (questionNo == "x")
                return

            if (questionNo.toIntOrNull() != null)
                qb.questions[questionNo.toInt() - 1].run()
            else {
                println("\nPlease enter valid question number!\n")
            }
        }
    }
}