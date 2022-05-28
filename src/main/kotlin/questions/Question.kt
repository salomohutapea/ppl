package questions

interface Question {

    val questionName: String

    fun getInput()
    fun calculate(): Any
    fun printQuestionName()
    fun printOutput()
    fun run()

}