package questions

import Questions
import kotlin.math.abs

class DiagonalDifference(private var n: Int = -1, private var arr: Array<Array<Int>> = arrayOf()) : Questions {

    override fun getInput() {
        super.getInput()

        if (n == -1 && arr.isEmpty()) {
            n = readLine()!!.trim().toInt()
            arr = Array(n) { Array(n) { 0 } }

            for (i in 0 until n) {
                arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
            }
        }
    }

    override fun calculate(): Int {
        var x = 0

        arr.forEachIndexed { i, z ->
            x += z[i] - z[arr.size - i - 1]
        }

        return abs((x))
    }

    override fun printQuestionName(questionName: String) {
        super.printQuestionName("Diagonal Difference")
    }
}