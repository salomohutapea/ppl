package main

import api.Api
import api.EnabledQuestions
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.spyk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import questions.QuestionsBank
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.stream.Stream

internal class MainTest {

    companion object {
        val mockApi = spyk(Api).apply {
            every { this@apply.getEnabledQuestionsFromApi() } returns EnabledQuestions(
                DIAGONAL_DIFFERENCE = true,
                MIN_MAX_SUM = true
            )
        }

        @JvmStatic
        fun printListOfQuestions(): Stream<Arguments?>? {

            return Stream.of(
                Arguments.of(
                    QuestionsBank(), ""
                ),
                Arguments.of(
                    QuestionsBank(mockApi), "List of Questions: \n" +
                            "[1] Diagonal Difference\n" +
                            "[2] Min Max Sum"
                ),
            )
        }

        @JvmStatic
        fun validateQuestionNoInput(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    "x", ""
                ),
                Arguments.of(
                    "z", "API Not Found"
                )
            )
        }
    }

    private val standardOut = System.out
    private val outputStreamCaptor: ByteArrayOutputStream = ByteArrayOutputStream()

    private lateinit var main: Main

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        clearAllMocks()
    }

    @ParameterizedTest
    @MethodSource
    fun printListOfQuestions(qb: QuestionsBank, expected: String) {

        main = Main(qb)
        main.printListOfQuestions()

        assertEquals(qb.questions, main.qb.questions)
        assertEquals(
            expected,
            outputStreamCaptor.toString()
                .trim()
        )
    }

    @ParameterizedTest
    @MethodSource
    fun validateQuestionNoInput(input: String, expected: String) {
        main = Main(QuestionsBank(mockApi))
        main.validateQuestionNoInput(input)

        assertEquals(
            expected,
            outputStreamCaptor.toString()
                .trim()
        )
    }

}