package blackjack

import blackjack.state.Hit
import blackjack.state.PlayerState

class Player(
    private val name: String,
    private val hand: Cards = Cards(),
    private val state: PlayerState = Hit,
) {
    fun addCardToHand(card: Card): Player {
        return Player(name = this.name, hand = this.hand.add(card))
    }

    fun handSize(): Int {
        return this.hand.size()
    }

    fun isStart(): Boolean = this.state.isStart()
    fun isHit(): Boolean = this.state.isHit()
    fun isStay(): Boolean = this.state.isStay()
    fun isBust(): Boolean = this.state.isBust()
    fun isBlackjack(): Boolean = this.state.isBlackjack()
}
