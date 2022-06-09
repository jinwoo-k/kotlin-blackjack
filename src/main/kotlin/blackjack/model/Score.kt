package blackjack.model

@JvmInline
value class Score(val value: Int) {

    init {
        require(value > 0) {
            "1보다 작은 수는 들어올 수 없습니다."
        }
    }

    fun isLose(): Boolean {
        return value > MAX_SCORE_CRITERIA
    }

    operator fun plus(that: Score): Score {
        return Score(value + that.value)
    }

    companion object {
        private const val MAX_SCORE_CRITERIA = 21
    }
}
