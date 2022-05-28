package questions

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class DiagonalDifferenceTest {

    companion object {
        @JvmStatic
        fun calculate(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(3, arrayOf(arrayOf(11, 2, 4), arrayOf(4, 5, 6), arrayOf(10, 8, -12)), 15)
            )
        }
    }

    private lateinit var diagonalDifference: DiagonalDifference

    @BeforeEach
    fun setup() {

    }

    @BeforeEach
    fun tearDown() {
    }

    @ParameterizedTest
    @MethodSource
    fun calculate(n: Int, input: Array<Array<Int>>, expected: Int) {
        diagonalDifference = DiagonalDifference(n, input)
        assertEquals(diagonalDifference.calculate(), expected)
    }
}