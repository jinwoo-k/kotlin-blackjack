package blackjack.model

class PlayerResult(override val player: User, val win: Boolean) : Result<User>
