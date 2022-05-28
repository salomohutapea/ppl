import questions.DiagonalDifference
import questions.MinMaxSum

class QuestionsBank {
    var questions: ArrayList<Questions> = arrayListOf()

    init {
        questions = arrayListOf(
            DiagonalDifference(),
            MinMaxSum()
        )
    }
}