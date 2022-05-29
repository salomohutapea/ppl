package questions

import api.Api
import com.google.gson.Gson

object QuestionsBank {
    var questions: ArrayList<Question> = arrayListOf()

    init {
        val enabledQuestions = Api.getEnabledQuestions()
        println(Gson().toJson(enabledQuestions))
        if (enabledQuestions.DIAGONAL_DIFFERENCE) questions.add(DiagonalDifference())
        if (enabledQuestions.MIN_MAX_SUM) questions.add(MinMaxSum())
    }
}