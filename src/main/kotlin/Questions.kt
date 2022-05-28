import com.google.gson.Gson

abstract class Questions {
    abstract val questionName: String
    open fun getInput() {
        println("Input :")
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