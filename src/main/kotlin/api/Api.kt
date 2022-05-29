package api

import com.google.gson.Gson
import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object Api {
    private val client: HttpClient = HttpClient.newBuilder().build()
    private val request: HttpRequest = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:2000"))
        .build()

    fun getEnabledQuestions(): EnabledQuestions {
        var enabledQuestions = EnabledQuestions(DIAGONAL_DIFFERENCE = true, MIN_MAX_SUM = true)
        try {
            enabledQuestions = getEnabledQuestionsFromApi()
        } catch (e: IOException) {
            println("API Not Found\n")
        }
        return enabledQuestions
    }

    fun getEnabledQuestionsFromApi(): EnabledQuestions {
        val response: HttpResponse<String> = client.send(request, HttpResponse.BodyHandlers.ofString())
        return Gson().fromJson(response.body(), EnabledQuestions::class.java)
    }
}