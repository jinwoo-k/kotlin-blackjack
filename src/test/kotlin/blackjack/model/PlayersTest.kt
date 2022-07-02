package blackjack.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PlayersTest {
    private val users = Users(listOf(User("jason")))
    private val dealer = Dealer()
    private val players = Players(users, dealer)

    @Test
    fun `Users를 업데이트 한다`() {
        Assertions.assertThat(players.withUsers { it.find(users.values[0].name)!!.cards.values.size }).isEqualTo(0)

        players.updateUsers { it.withAllPlayers { it.addCards(listOf(Card(CardNumber.Six, Suit.Spade))) } }
        Assertions.assertThat(players.withUsers { it.find(users.values[0].name)!!.cards.values.size }).isEqualTo(1)
    }

    @Test
    fun `Dealer를 업데이트 한다`() {
        Assertions.assertThat(players.withDealer { it.cards.values.size }).isEqualTo(0)

        players.updateDealer { it.addCards(listOf(Card(CardNumber.Six, Suit.Spade))) }
        Assertions.assertThat(players.withDealer { it.cards.values.size }).isEqualTo(1)
    }
}
