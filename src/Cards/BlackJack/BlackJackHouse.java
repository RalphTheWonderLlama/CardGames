package Cards.BlackJack;

import Cards.CardDeck;

public class BlackJackHouse extends BlackjackPlayer {
	CardDeck deck;
	boolean turn;

	public BlackJackHouse(BlackJackHand h, CardDeck C) {
		super(h, 1);
		deck = C;
		turn = false;
	}

	public String toString() {
		String x = "";
		if (this.Hand.getCards().size() > 0) {
			if (!turn) {
				x += "The house shows a " + this.Hand.getCards().get(0);
			} else {
				x += "The house has " + this.Hand.toString();
				if (this.busted()) {
					x += "\nThe house has busted!";
				}
			}
		}
		return x;
	}

	public boolean hasBlackjack() {
		return super.Hand.value() == 35;
	}

	public int turn() {
		turn = true;
		while (this.Hand.value() != -1 && this.Hand.value() < 17) {
			this.hit(deck.getNextCard());
		}
		return this.Hand.value();
	}

	public void resetHand() {
		super.resetHand();
		turn = false;
	}

}
