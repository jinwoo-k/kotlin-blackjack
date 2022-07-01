package blackjack.model

interface Result<P : Player<P>> {
    val player: P
}
