package questions

import com.google.gson.Gson

abstract class Question {
    abstract val questionName: String
    open fun getInput() {
        println("\nInput :")
    }

    abstract fun calculate(): Any

    open fun printQuestionName() {
        println("\n$questionName")
    }

    private fun printOutput() {
        println("\nOutput :")
        println(Gson().toJson(calculate()))
    }

    fun run() {
        printQuestionName()
        getInput()
        printOutput()
    }
}