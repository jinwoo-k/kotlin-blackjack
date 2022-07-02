package blackjack.view

import blackjack.model.BlackjackGame
import blackjack.model.Cards
import blackjack.model.Dealer
import blackjack.model.Player
import blackjack.model.Results
import blackjack.model.User
import blackjack.model.Users

object OutputView {

    private fun <P : Player<P>> printPlayerWithScore(player: P) {
        println("${player.name}카드: ${cardsToString(player.cards)} - 결과 : ${player.cards.optimalScore().value}")
    }

    private fun cardsToString(cards: Cards, skip: Int = 0): String {
        return cards.values
            .drop(skip)
            .joinToString(",") {
                "${CardNumberView.toString(it.cardNumber)}${SuitView.toString(it.suit)}"
            }
    }

    fun printInitialState(game: BlackjackGame) {
        game.players.with { users, dealer ->
            println("${dealer.name}와 ${users.values.joinToString(", ") { it.name }}에게 2장의 카드를 나누어 주었습니다.")
            printDealer(dealer)
            printPlayers(users)
            println()
        }
    }

    fun printFinalState(game: BlackjackGame) {
        game.players.with { users, dealer ->
            printPlayerWithScore(dealer)
            users.values.forEach { printPlayerWithScore(it) }
        }
    }

    fun printWinners(results: Results) {
        println("\n ## 최종 승패")
        println("${results.dealerResult.player.name} : ${results.dealerResult.win}승 ${results.dealerResult.lose}패")
        results.playerResults.forEach { playerResult ->
            println("${playerResult.player.name} : ${if (playerResult.win) "승" else "패"}")
        }
    }

    private fun printPlayers(users: Users) {
        users.values.forEach { printPlayer(it) }
        println()
    }

    fun printPlayer(player: User) {
        println("${player.name}카드: ${cardsToString(player.cards)}")
    }

    fun printDealerHit() {
        println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.")
    }

    private fun printDealer(player: Dealer) {
        println("${player.name}카드: ${cardsToString(player.cards, skip = 1)}")
    }
}
