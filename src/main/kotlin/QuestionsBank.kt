import questions.DiagonalDifference

object QuestionsBank {
    var questions: ArrayList<() -> Unit> = arrayListOf()

    init {
        questions = arrayListOf(
            { DiagonalDifference().run() },
            { DiagonalDifference().run() }
        )
    }
}