package blackjack.model

class BlackjackGame(initUsers: Users) {
    private var cards: Cards = Cards.shuffledCards()
    var users: Users = initUsers
    var dealer: Dealer = Dealer()

    init {
        users = users.withAllPlayers {
            hit(it, Cards.NUMBER_OF_INIT_CARDS)
        }

        dealer = hit(dealer, Cards.NUMBER_OF_INIT_CARDS)
    }

    private fun <T : Player<T>> hit(player: T, numOfCards: Int = Cards.NUMBER_OF_GIVE_CARDS): T {
        val (extractedCards, newCards) = cards.pollCards(numOfCards)
        cards = newCards
        return player.addCards(extractedCards)
    }

    fun isGameOver(): Boolean {
        return users.isAllOver()
    }

    fun playUser(getHit: (User) -> Boolean): User {
        val player = users.findNotOver().first()
        if (getHit(player)) {
            users = users.update(hit(player))
        } else {
            users = users.stay(player)
        }
        return users.find(player.name) ?: player
    }

    fun isDealerGameOver(): Boolean {
        return dealer.cards.optimalScore().value > Score.DELAER_HIT_CRITERIA && !dealer.cards.isSoft()
    }

    fun playDealer(): Dealer {
        dealer = hit(dealer)
        return dealer
    }

    fun createResults(): Results {
        return Results(users, dealer)
    }
}
