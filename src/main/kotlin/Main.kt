fun main() {

    val questions = QuestionsBank.questions

    println("List of Questions: ")

    questions.forEachIndexed { i, q ->
        println("[${i + 1}] ${q.questionName}")
    }


    println("\nEnter question no, [x] to exit this program:")

    val questionNo: String = readLine()!!

    if (questionNo == "x")
        return

    if (questionNo.toIntOrNull() != null)
        questions[questionNo.toInt() - 1].run()
    else {
        println("\nPlease enter valid question number!\n")
    }
}