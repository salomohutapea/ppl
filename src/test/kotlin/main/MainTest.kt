package main

import io.mockk.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import questions.Question
import questions.QuestionsBank
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.stream.Stream

internal class MainTest {

    companion object {
        @JvmStatic
        fun printListOfQuestions(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    QuestionsBank.questions, "List of Questions: \n" +
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
                    "z", "Please enter valid question number!"
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
    fun printListOfQuestions(q: ArrayList<Question>, expected: String) {
        main = Main(q)
        main.printListOfQuestions()

        assertEquals(QuestionsBank.questions, main.questions)
        assertEquals(
            expected,
            outputStreamCaptor.toString()
                .trim()
        )
    }

    @ParameterizedTest
    @MethodSource
    fun validateQuestionNoInput(input: String, expected: String) {
        main = Main()
        main.validateQuestionNoInput(input)

        assertEquals(
            expected,
            outputStreamCaptor.toString()
                .trim()
        )
    }

}