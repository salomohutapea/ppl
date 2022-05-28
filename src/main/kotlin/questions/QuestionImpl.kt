package questions

import com.google.gson.Gson

open class QuestionImpl : Question {

    override val questionName: String = ""

    override fun getInput() {
        println("\nInput :")
    }

    override fun printQuestionName() {
        println("\n$questionName")
    }

    override fun printOutput() {
        println("\nOutput :")
        println(Gson().toJson(calculate()))
    }

    override fun run() {
        printQuestionName()
        getInput()
        printOutput()
    }

}