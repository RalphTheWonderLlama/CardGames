package Cards.BlackJack;

import java.util.ArrayList;

import Cards.Card;


public class BlackjackPlayer {
	protected BlackJackHand Hand;
	private int bet;
	private int balance;
	private ArrayList<BlackJackHand> splits;

	public BlackjackPlayer(BlackJackHand h, int b) {
		balance = b;
		if (h != null) {
			Hand = h;
		} else {
			Hand = new BlackJackHand(new Card[0]);
		}
		bet = 0;
		splits = new ArrayList<BlackJackHand>();
	}

	public void bet(int b) {
		if (b < 0) {
			throw new IllegalArgumentException("Bet must be a positive number");
		} else if (b > balance) {
			bet = balance;
			balance = 0;
		} else {
			bet = b;
			balance -= b;
		}
	}

	public void hit(Card c) {
		Hand.addCard(c);
	}

	public String toString() {
		String score;
		if (Hand.busted()) {
			score = "\nYou bust";
		} else if (Hand.value() == 35) {
			score = "\nBlack Jack!";
		} else {
			score = "\nTotal: " + Hand.value();
		}
		String x = "Your cards: " + Hand + score + "\nBet: " + bet + "\nBalance: " + balance;
		return x;
	}

	public void win() {
		balance += 2 * bet;
		bet = 0;
		resetHand();
	}

	public void lose() {
		bet = 0;
		resetHand();
	}

	public void push() {
		balance += bet;
		bet = 0;
		resetHand();
	}

	public void blackJack() {
		balance += 2.5 * bet;
		bet = 0;
		resetHand();
	}
	
	public void resetHand() {
		Hand = new BlackJackHand(new Card[0]);
	}
	public int getBalance() {
		return balance;
	}
	public boolean busted() {
		return Hand.busted();
	}
	public int value() {
		return Hand.value();
	}

	public int getBet() {
		return bet;
	}
}
