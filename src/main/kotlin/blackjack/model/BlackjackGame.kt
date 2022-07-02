package blackjack.model

class BlackjackGame(initUsers: Users) {
    private var cards = Cards.shuffledCards()
    val players: Players

    init {
        players = Players(initUsers, Dealer())
        players.updateUsers { users ->
            users.withAllPlayers { user ->
                hit(user, Cards.NUMBER_OF_INIT_CARDS)
            }
        }
        players.updateDealer { hit(it, Cards.NUMBER_OF_INIT_CARDS) }
    }

    private fun <T : Player<T>> hit(player: T, numOfCards: Int = Cards.NUMBER_OF_GIVE_CARDS): T {
        val (extractedCards, newCards) = cards.pollCards(numOfCards)
        cards = newCards
        return player.addCards(extractedCards)
    }

    fun isGameOver(): Boolean {
        return players.withUsers { it.isAllOver() }
    }

    fun playUser(getHit: (User) -> Boolean): User {
        val user = players.withUsers { it.findNotOver().first() }

        players.updateUsers {
            if (getHit(user)) {
                return@updateUsers it.update(hit(user))
            } else {
                return@updateUsers it.stay(user)
            }
        }

        return players.withUsers { it.find(user.name) ?: user }
    }

    fun isDealerGameOver(): Boolean {
        return players.withDealer {
            it.cards.optimalScore().value > Score.DELAER_HIT_CRITERIA && !it.cards.isSoft()
        }
    }

    fun playDealer(): Dealer {
        return players.updateDealer {
            hit(it)
        }
    }

    fun createResults(): Results {
        return players.with { users, dealer -> Results(users, dealer) }
    }
}
