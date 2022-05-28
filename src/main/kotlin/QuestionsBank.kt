import questions.DiagonalDifference

class QuestionsBank {
    var questions: ArrayList<() -> Unit> = arrayListOf()

    init {
        questions = arrayListOf(
            { DiagonalDifference().run() },
            { DiagonalDifference().run() }
        )
    }
}