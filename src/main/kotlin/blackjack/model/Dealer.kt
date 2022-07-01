package blackjack.model

class Dealer(cards: Cards = Cards.emptyCards(), stay: Boolean = false) : Player<Dealer>(DEALER_NAME, cards, stay) {
    override fun create(name: String, cards: Cards, stay: Boolean): Dealer {
        return Dealer(cards, stay)
    }

    companion object {
        private const val DEALER_NAME = "딜러"
    }
}
