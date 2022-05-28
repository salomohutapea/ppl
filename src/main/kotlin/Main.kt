fun main() {
    Main()
}

class Main(
    private val questions: ArrayList<Question> = QuestionsBank.questions,
    private var questionNo: String = ""
) {

    init {
        printListOfQuestions()
        enterQuestionNo()
    }

    private fun printListOfQuestions() {
        println("List of Questions: ")

        questions.forEachIndexed { i, q ->
            println("[${i + 1}] ${q.questionName}")
        }
    }

    private fun enterQuestionNo() {
        println("\nEnter question number or [x] to exit this program:")

        if (questionNo.isEmpty()) questionNo = readLine()!!

        if (questionNo == "x")
            return

        if (questionNo.toIntOrNull() != null)
            questions[questionNo.toInt() - 1].run()
        else {
            println("\nPlease enter valid question number!\n")
        }
    }
}