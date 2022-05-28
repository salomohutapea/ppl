import com.google.gson.Gson

interface Questions {
    fun getInput() {
        println("Input :")
    }

    fun calculate(): Any

    fun printQuestionName(questionName: String = "") {
        println(questionName + "\n")
    }

    fun printOutput() {
        println("\nOutput :")
        println(Gson().toJson(calculate()))
    }

    fun run() {
        printQuestionName()
        getInput()
        printOutput()
    }
}