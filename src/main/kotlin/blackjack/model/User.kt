package blackjack.model

class User(name: String, cards: Cards = Cards.emptyCards(), stay: Boolean = false) : Player<User>(name, cards, stay) {
    override fun create(name: String, cards: Cards, stay: Boolean): User {
        return User(name, cards, stay)
    }
}
