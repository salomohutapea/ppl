package questions

import Questions

class MinMaxSum(private var arr: Array<Int> = arrayOf()) : Questions() {

    override val questionName: String = "Min Max Sum"

    override fun getInput() {
        super.getInput()

        arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    override fun calculate(): Any {
        arr.sort()
        var min: Long = 0
        var max: Long = 0
        for (i in 1 until arr.size) {
            min += arr[i - 1]
            max += arr[i]
        }
        return arrayOf(min, max)
    }

}