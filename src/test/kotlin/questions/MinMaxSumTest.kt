package questions

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MinMaxSumTest {

    companion object {
        @JvmStatic
        fun calculate(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(arrayOf(1, 2, 3, 4, 5), "10 14")
            )
        }
    }

    private lateinit var minMaxSum: MinMaxSum

    @BeforeEach
    fun setup() {

    }

    @AfterEach
    fun tearDown() {
    }

    @ParameterizedTest
    @MethodSource
    fun calculate(input: Array<Int>, expected: String) {
        minMaxSum = MinMaxSum(input)
        kotlin.test.assertEquals(minMaxSum.calculate(), expected)
    }
}