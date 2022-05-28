package questions

class MinMaxSum(
    private var arr: Array<Int> = arrayOf(),
    private val questionImpl: Question = QuestionImpl()
) : Question {

    override val questionName: String = "Min Max Sum"

    override fun getInput() {
        questionImpl.getInput()
        if (arr.isEmpty()) arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    override fun calculate(): String {
        arr.sort()
        var min: Long = 0
        var max: Long = 0
        for (i in 1 until arr.size) {
            min += arr[i - 1]
            max += arr[i]
        }
        return "$min $max"
    }

}