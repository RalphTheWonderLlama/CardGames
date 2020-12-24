package Cards.Poker;
import java.util.ArrayList;
import java.util.Scanner;

import Cards.CardDeck;
import Cards.Utilities;

public abstract class PokerRound {
	private int pot;
	private static PokerPlayer[] players;
	private int turnNumber;
	private static CardDeck deck;
	private static int minRaise;
	public PokerRound(PokerPlayer[] p, int minRaise) {
		pot = 0;
		players = p;
		deck = new CardDeck();
		PokerRound.minRaise = minRaise;
		PokerHand[] hand = deck.deal(players.length);
		for(int i = 0; i<players.length; i++) {
			players[i].setHand(hand[i]);
		}
	}
	public void reset() {
		pot = 0;
		deck.shuffle();
		turnNumber = 0;
		for(int i = 0; i<players.length; i++) {
			if(players[i].getBal()>0) {
				players[i].setFold(false);
			}
		}
		PokerHand[] hand = deck.deal(players.length);
		for(int i = 0; i<players.length; i++) {
			players[i].setHand(hand[i]);
		}
	}
	public static void clearConsole() {
		for(int i= 0; i<1000; i++) {
			System.out.println("\n");
		}
		System.out.println("Cleared!");
	}
	public boolean RoundEnd() {
		
		System.out.println("Round Over");
		for(int i = 0; i<players.length; i++) {
			if(players[i].isFolded()) {
				System.out.println("Player "+(i+1)+": Folded");
			} else {
				System.out.println("Player "+(i+1)+": "+players[i].getHand().toString());
			}
		}	
	    boolean tie = false;
		PokerPlayer winner = (PokerPlayer) Utilities.getGreatest(players);
		for(int i = 0; i<players.length; i++) { //test for tie
			if(winner.getValue() == players[i].getValue() && winner!=players[i]) {
				tie = true;
			}
		}
		if(tie) {
			ArrayList<PokerPlayer> winners = new ArrayList<PokerPlayer>();
			ArrayList<Integer> numbs = new ArrayList<Integer>();
			for(int i = 0; i<players.length; i++) {
				if(winner.getValue() == players[i].getValue()){
					winners.add(players[i]);
					numbs.add(i+1);
				}
			}
			for(int i = 0; i<winners.size(); i++) {
				winners.get(i).increaseBal(pot/winners.size());
			}
			System.out.print("Winners:");
			for(int i = 0; i<numbs.size(); i++) {
				System.out.print(" Player "+numbs.get(i));
				if(i!=numbs.size()-1) {
					System.out.print(",");
				}
			}
			System.out.println();
			System.out.println("	Winnings per player: "+(pot/winners.size()));
			
		} else {
			int playerNumb = 0;
			for(int i = 0; i<players.length; i++) {
				if(players[i] == winner) {
					playerNumb = i+1;
					break;
				}	
			}
			winner.increaseBal(pot);
			System.out.println("Winner: Player "+playerNumb+"\n	Winnings: "+pot);			
		}
		
		System.out.println("Play Again?\nYes | No");
		while(true) {
			Scanner ky = new Scanner(System.in);
			String x = ky.nextLine();
			if(x.equalsIgnoreCase("yes")) {
				this.reset();
				return true;
			} else if(x.equalsIgnoreCase("no")) {
				return false;
			} else {
				System.out.println("Invalid response. Please enter a valid resoponse (\"Yes\" or \"No\")."
						+ "\nPlay Again?\nYes | No");
			}
		}
	}
	public abstract boolean playRound();
}
