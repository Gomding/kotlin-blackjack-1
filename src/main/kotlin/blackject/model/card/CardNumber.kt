package blackject.model.card

/**
 * 카드 숫자 정보
 * */
enum class CardNumber (
    val numberName: String,
) {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    KING("K"),
    QUEEN("Q"),
    JACK("J");

    companion object {
        private const val ACE_MIN_VALUE = 1
        private const val ACE_MAX_VALUE = 11
        private const val LOYAL_VALUE = 10
        private const val DEFAULT_NUMBER = 0

        fun isAce(numberName: String): Boolean {
            return ACE.numberName == numberName
        }

        fun isRoyal(numberName: String): Boolean {
            return (KING.numberName == numberName) || (QUEEN.numberName == numberName) || (JACK.numberName == numberName)
        }

        fun getNumberMinValue(number: CardNumber?): Int {
            return when {
                number == null -> DEFAULT_NUMBER
                isAce(number.numberName) -> ACE_MIN_VALUE
                isRoyal(number.numberName) -> LOYAL_VALUE
                else -> number.numberName.toInt()
            }
        }

        fun getNumberMaxValue(number: CardNumber?): Int {
            return when {
                number == null -> DEFAULT_NUMBER
                isAce(number.numberName) -> ACE_MAX_VALUE
                isRoyal(number.numberName) -> LOYAL_VALUE
                else -> number.numberName.toInt()
            }
        }
    }
}