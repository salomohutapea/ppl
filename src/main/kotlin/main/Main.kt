package main

import questions.Question

fun main() {
    val main = Main()
    main.printListOfQuestions()
    main.enterQuestionNo()
}

class Main(
    private val questions: ArrayList<Question> = QuestionsBank.questions
) {

    fun printListOfQuestions() {
        println("List of Questions: ")

        questions.forEachIndexed { i, q ->
            println("[${i + 1}] ${q.questionName}")
        }
    }

    fun enterQuestionNo() {
        println("\nEnter question number or [x] to exit this program:")

        val questionNo: String = readLine()!!

        validateQuestionNoInput(questionNo)
    }

    fun validateQuestionNoInput(questionNo: String) {
        if (questionNo == "x")
            return

        if (questionNo.toIntOrNull() != null)
            questions[questionNo.toInt() - 1].run()
        else {
            println("\nPlease enter valid question number!\n")
        }
    }
}