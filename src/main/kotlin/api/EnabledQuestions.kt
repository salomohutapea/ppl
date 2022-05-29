package api

import com.google.gson.annotations.SerializedName

data class EnabledQuestions(
    @SerializedName("DIAGONAL_DIFFERENCE") val DIAGONAL_DIFFERENCE: Boolean,
    @SerializedName("MIN_MAX_SUM") val MIN_MAX_SUM: Boolean
)
