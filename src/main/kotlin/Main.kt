fun main() {

    val questions = QuestionsBank.questions

    println("List of Questions: ")

    questions.forEachIndexed { i, q ->
        println("[${i + 1}] ${q.questionName}")
    }

    println("\nEnter question no: ")

    val questionNo: Int = readLine()!!.toInt()

    questions[questionNo].run()
}