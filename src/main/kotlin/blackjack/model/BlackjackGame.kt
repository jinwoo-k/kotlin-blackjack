package blackjack.model

class BlackjackGame(initPlayers: Players) {
    private var cards: Cards = Cards.shuffledCards()
    var players: Players = initPlayers
    var dealer: Dealer = Dealer()

    init {
        players = players.withAllPlayers {
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
        return players.isAllOver()
    }

    fun playUser(getHit: (User) -> Boolean): User {
        val player = players.findNotOver().first()
        if (getHit(player)) {
            players = players.update(hit(player))
        } else {
            players = players.stay(player)
        }
        return players.find(player.name) ?: player
    }

    fun isDealerGameOver(): Boolean {
        return dealer.cards.optimalScore().value > Score.DELAER_HIT_CRITERIA && !dealer.cards.isSoft()
    }

    fun playDealer(): Dealer {
        dealer = hit(dealer)
        return dealer
    }

    fun createResults(): Results {
        return Results(players, dealer)
    }
}
