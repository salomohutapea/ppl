import kotlin.math.abs

object DiagonalDifference : Questions {
    override fun calculate(): Int {
        val n = readLine()!!.trim().toInt()

        val arr = Array(n) { Array(n) { 0 } }

        for (i in 0 until n) {
            arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        }

        var x = 0

        arr.forEachIndexed { i, z ->
            x += z[i] - z[arr.size - i - 1]
        }

        return abs((x))
    }

    override fun printQuestion(questionName: String) {
        super.printQuestion("Diagonal Difference")
    }
}