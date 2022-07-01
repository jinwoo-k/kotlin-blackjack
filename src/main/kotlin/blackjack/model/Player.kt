package blackjack.model

abstract class Player<P : Player<P>>(val name: String, val cards: Cards = Cards.emptyCards(), val stay: Boolean = false) {
    abstract fun create(name: String, cards: Cards, stay: Boolean): P

    fun scores(): List<Score> {
        return cards.scores
    }

    fun setStay(): P {
        return create(name, cards, stay = true)
    }

    fun addCards(newCardList: List<Card>): P {
        return create(name, cards.addCards(newCardList), stay)
    }

    fun isGameOver(): Boolean {
        return stay || cards.optimalScore().isBust()
    }

    fun <T : Player<T>> isWinThen(that: T): Boolean {
        return cards.optimalScore().isWinThan(that.cards.optimalScore())
    }
}
