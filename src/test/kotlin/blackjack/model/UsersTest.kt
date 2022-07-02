package blackjack.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UsersTest {
    val playerList = listOf(User("jason", Cards(listOf(Card(CardNumber.Two, Suit.Heart)))))

    @Test
    fun `Player들을 속성으로 갖는다`() {
        assertThat(Users(playerList).values).isEqualTo(playerList)
    }

    @Test
    fun `아직 종료되지 않은 유저 목록을 반환한다`() {
        assertThat(Users(playerList).findNotOver()).isEqualTo(playerList)
        assertThat(Users(playerList.map { it.setStay() }).findNotOver()).isEmpty()
    }

    @Test
    fun `이름으로 플레이어를 찾는다`() {
        assertThat(Users(playerList).find("jason")).isNotNull
        assertThat(Users(playerList).find("jinwoo")).isNull()
    }
}
