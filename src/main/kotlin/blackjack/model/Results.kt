package blackjack.model

class Results(users: Users, dealer: Dealer) {
    val playerResults: List<PlayerResult>
    val dealerResult: DealerResult

    init {
        playerResults = users.values.map { player ->
            PlayerResult(player, player.isWinThen(dealer))
        }

        val playerWinCnt = playerResults.count { it.win }
        val dealerWinCnt = playerResults.count { !it.win }
        dealerResult = DealerResult(dealer, dealerWinCnt, playerWinCnt)
    }
}
