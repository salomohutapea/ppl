import questions.DiagonalDifference
import questions.MinMaxSum

object QuestionsBank {
    var questions: ArrayList<Question> = arrayListOf()

    init {
        questions = arrayListOf(
            DiagonalDifference(),
            MinMaxSum()
        )
    }
}