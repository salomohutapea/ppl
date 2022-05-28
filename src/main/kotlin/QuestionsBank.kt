import questions.DiagonalDifference
import questions.MinMaxSum

object QuestionsBank {
    var questions: ArrayList<Questions> = arrayListOf()

    init {
        questions = arrayListOf(
            DiagonalDifference(),
            MinMaxSum()
        )
    }
}