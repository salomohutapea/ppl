package questions

import api.Api

class QuestionsBank(api: Api = Api) {
    var questions: ArrayList<Question> = arrayListOf()

    init {
        val enabledQuestions = api.getEnabledQuestions()
        enabledQuestions?.let {
            if (it.DIAGONAL_DIFFERENCE) questions.add(DiagonalDifference())
            if (it.MIN_MAX_SUM) questions.add(MinMaxSum())
        }
    }
}