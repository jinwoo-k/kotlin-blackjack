package blackjack.model

class Users(val values: List<User>) {
    fun findNotOver(): List<User> {
        return values.filter { !it.stay }
    }

    fun stay(player: User): Users {
        return Users(
            values.map {
                if (player.name == it.name) {
                    player.setStay()
                } else {
                    it
                }
            }
        )
    }

    fun update(player: User): Users {
        return Users(
            values.map {
                if (player.name == it.name) {
                    player
                } else {
                    it
                }
            }
        )
    }

    fun isAllOver(): Boolean {
        return values.all { it.isGameOver() }
    }

    fun find(name: String): User? {
        return values.find { it.name == name }
    }

    fun withAllPlayers(f: (User) -> User): Users {
        return Users(values.map { f(it) })
    }
}
