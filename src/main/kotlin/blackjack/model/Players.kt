package blackjack.model

class Players(private var users: Users, private var dealer: Dealer) {

    fun updateUsers(f: (Users) -> Users): Users {
        users = f(users)
        return users
    }

    fun <T> withUsers(f: (Users) -> T): T {
        return f(users)
    }

    fun updateDealer(f: (Dealer) -> Dealer): Dealer {
        dealer = f(dealer)
        return dealer
    }

    fun <T> withDealer(f: (Dealer) -> T): T {
        return f(dealer)
    }

    fun <T> with(f: (Users, Dealer) -> T): T {
        return f(users, dealer)
    }
}
