package Cards.BlackJack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cards.CardDeck;
import Cards.Card;

public class BlackJackGame {
	public static void main(String Args[]) {

		int numbDecks = 0;
		int playerNumb = 0;
		int startingBal = 2000;

		///////////////////
		// INITIAL SETUP //
		///////////////////

		Object[] deckOptions = { 6, 2, 1 };
		Object[] options = { 5, 4, 3, 2, 1 };
		int playerNumbRet = JOptionPane.showOptionDialog(null, "Select the number of Players", "Black Jack", 0, 1, null,
				options, 1);

		switch (playerNumbRet) {
		case 0:
			playerNumb = 5;
			break;
		case 1:
			playerNumb = 4;
			break;
		case 2:
			playerNumb = 3;
			break;
		case 3:
			playerNumb = 2;
			break;
		case 4:
			playerNumb = 1;
			break;
		case -1:
			System.exit(0);
			break;
		}

		int DeckNumbRet = JOptionPane.showOptionDialog(null, "Select the number of Decks", "Black Jack", 0, 1, null,
				deckOptions, 1);

		switch (DeckNumbRet) {
		case 0:
			numbDecks = 6;
			break;
		case 1:
			numbDecks = 2;
			break;
		case 2:
			numbDecks = 1;
			break;
		case -1:
			System.exit(0);
			break;
		}

		CardDeck c = new CardDeck(numbDecks, true);
		BlackjackPlayer[] Players = new BlackjackPlayer[playerNumb + 1];
		Players[playerNumb] = new BlackJackHouse(null, c);
		for (int i = 0; i < playerNumb; i++) {
			Players[i] = new BlackjackPlayer(null, startingBal);
		}

		/////////////////////////////
		while (true) {
			while (c.numbRemainingCards() > (52 * numbDecks) / 4) {

				////////////////////////
				// Ask Player for Bet //
				////////////////////////

				for (int i = 0; i < playerNumb; i++) {
					if (Players[i].getBalance() > 0) {
						String bet = JOptionPane.showInputDialog(null,
								"Please enter your bet. Balance: " + Players[i].getBalance(), "Player " + (1 + i), 1);
						Players[i].bet(Integer.parseInt(bet));
					}
				}
				deal(Players, c);
				// System.out.println(Players[playerNumb].Hand.getCards().toString());

				////////////////////////////////
				// Check for House Black Jack //
				////////////////////////////////

				if (((BlackJackHouse) Players[playerNumb]).hasBlackjack()) {
					String x = "The House has a Black Jack";
					for (int i = 0; i < playerNumb; i++) {
						if (Players[i].getBet() > 0) {
							if (Players[i].value() == 35) {
								x += "\nPlayer " + (i + 1) + ": Push";
								Players[i].push();
							} else {
								x += "\nPlayer " + (i + 1) + ": Loss";
								Players[i].lose();
							}
						}
					}
					JOptionPane.showMessageDialog(null, x, "Black Jack", 1);

				} else {

					/////////////////////////////
					// Go through player turns //
					/////////////////////////////

					for (int i = 0; i < playerNumb; i++) {
						if (Players[i].getBet() > 0) {
							String[] choices = { "Stay", "Hit" };
							int decision = 1;
							while (decision == 1 && !Players[i].busted()) {
								decision = JOptionPane.showOptionDialog(null,
										Players[i].toString() + "\n" + Players[playerNumb].toString(),
										"Player " + (1 + i), 0, 1, null, choices, 1);
								if (decision == 1) {
									Players[i].hit(c.getNextCard());
								}
								if (Players[i].busted()) {
									JOptionPane.showMessageDialog(null, "You Bust\n" + Players[i].toString(),
											"Player " + (i + 1), 0);
									decision = 0;
								}
							}
						}
					}

					///////////////////////
					// Determine Winners //
					///////////////////////

					((BlackJackHouse) Players[playerNumb]).turn();
					String x = Players[playerNumb].toString();
					for (int i = 0; i < playerNumb; i++) {
						if (Players[i].getBet() > 0) {
							if (Players[i].value() == 35) {
								x += "\nPlayer " + (i + 1) + ": Black Jack";
								Players[i].blackJack();
							} else if (Players[i].busted()) {
								x += "\nPlayer " + (i + 1) + ": Bust";
								Players[i].lose();
							} else if (Players[playerNumb].value() > Players[i].value()) {
								x += "\nPlayer " + (i + 1) + ": Loss";
								Players[i].lose();
							} else if (Players[i].value() > Players[playerNumb].value()) {
								x += "\nPlayer " + (i + 1) + ": Win";
								Players[i].win();
							} else {
								x += "\nPlayer " + (i + 1) + ": Push";
								Players[i].push();
							}
						}
					}

					JOptionPane.showMessageDialog(null, x, "Black Jack", 1);
					Players[playerNumb].resetHand();
				}

				////////////////
				// Reset here //
				////////////////

			}
			String[] o = { "No", "Yes" };
			int a = JOptionPane.showOptionDialog(null, "Deck finished. Shuffle and play again?", "Black Jack", 0, 1,
					null, o, 1);
			if (a == 1) {
				c.reshuffle();
			} else {
				break;
			}
		}
	}

	public static void deal(BlackjackPlayer[] Play, CardDeck deck) {
		for (int x = 0; x < 2; x++) {
			for (int i = 0; i < Play.length; i++) {
				if (Play[i].getBet() > 0 || i == Play.length - 1) {
					Play[i].hit(deck.getNextCard());
				}
			}
		}
	}
}
