package questions

object QuestionsBank {
    var questions: ArrayList<Question> = arrayListOf()

    init {
        questions = arrayListOf(
            DiagonalDifference(),
            MinMaxSum()
        )
    }
}