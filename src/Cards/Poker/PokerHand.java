package Cards.Poker;
import java.util.Arrays;

import Cards.Card;
import Cards.Utilities;
import Cards.Valued;
public class PokerHand implements Valued, Comparable<PokerHand>{
	private Card[] cards;
	private int score;

	/////////////////////////////////////////////////
	
	public PokerHand(Card[] c) {
		if(c.length == 5) {
			cards = c;
			score = this.updateScore();
		} else {
			throw new IllegalArgumentException();
		}
	}

	/////////////////////////////////////////////////
	
	public int updateScore() {
		int[] x= new int[cards.length];
		for(int i = 0; i<x.length; i++) {
			x[i] = cards[i].getNumber();
		}
		Arrays.sort(x);
		int prev = cards[0].getSuit();
		boolean flush = true;
		for(int i = 1; i<cards.length; i++) {
			if(prev != cards[i].getSuit()) {
				flush = false;
				break;
			}
		}
		if(flush) {
			score += 75 + x[x.length-1];
		}
		boolean straight = true;
		prev = x[0];
		boolean changed = false;
		if(x[x.length-1] == 14 && x[0]==2 ) {
			changed = true;
			x[x.length-1] = 1;
			Arrays.sort(x);
		}
		for(int i = 1; i<x.length; i++) {
			if(prev != x[i]-1) {
				straight = false;
				break;
			}
			prev++;
		}
		if(straight) {
			score+=60 + x[x.length-1];
		}
		if(changed) {
			x[0] = 14;
			Arrays.sort(x);
		}
		int pos = 0;
		int numbPairs = 0;
		boolean three = false;
		int cardP = 0;
		int cardT = 0;
		while(pos<x.length) {
			int z = Utilities.countAppearance(x[pos], x);
			if(z == 2) {
				numbPairs++;
				if(x[pos]>cardP) {
					cardP = x[pos];
				}
				pos+=2;
			} else if(z == 3) {
				three = true;
				cardT = x[pos];
				pos+=3;
			} else if(z == 4) {
				score+=105+x[pos];
				break;
			} else {
				pos++;
			}
		}
		if(three && numbPairs == 1) {
			score+=90+cardT;
		} else if(numbPairs == 2) {
			score+=30+cardP;
		} else if(numbPairs == 1) {
			score+=15+cardP;
		} else if(three) {
			score+=45+cardT;
		}
		if(score == 0) {
			score+=x[x.length-1];
		}
		return score;
	}
	
	/////////////////////////////////////////////////
	
	public int compareTo(PokerHand that) {
		int x = this.getScore()-that.getScore();
		if(x==0) {
			return PokerHand.breakTie(this, that);
		} else {
			return x;
		}
	}
	
	public int getValue() {
		return score;
	}
	
	/////////////////////////////////////////////////
	
	
	public static int breakTie(PokerHand a, PokerHand b) {
		int x = a.getScore();
		if(x<15) { //high card
			Card[] ac = a.getCards();
			Card[] bc = b.getCards();
			Arrays.sort(ac);
			Arrays.sort(bc);
			for(int i = 3; i>-1; i--) {
				if(ac[i].compareTo(bc[i])>0) {
					return 1;
				} else if(ac[i].compareTo(bc[i])<0) {
					return -1;
				} else {
					continue;
				}
			}
			return 0;
		} else if(x<30) { // Pair
			Card[] ac = a.getCards();
			Card[] bc = b.getCards();
			Arrays.sort(ac);
			Arrays.sort(bc);
			for(int i = 3; i>-1; i--) {
				if(ac[i].compareTo(bc[i])>0) {
					return 1;
				} else if(ac[i].compareTo(bc[i])<0) {
					return -1;
				} else {
					continue;
				}
			}
			return 0;
		} else if(x<45) { // 2 pair
			Card[] ac = a.getCards();
			Card[] bc = b.getCards();
			Arrays.sort(ac);
			Arrays.sort(bc);
			for(int i = 3; i>-1; i--) {
				if(ac[i].compareTo(bc[i])>0) {
					return 1;
				} else if(ac[i].compareTo(bc[i])<0) {
					return -1;
				} else {
					continue;
				}
			}
			return 0;
		} else if(x<60) { // 3 of a kind
			Card[] ac = a.getCards();
			Card[] bc = b.getCards();
			Arrays.sort(ac);
			Arrays.sort(bc);
			for(int i = 3; i>-1; i--) {
				if(ac[i].compareTo(bc[i])>0) {
					return 1;
				} else if(ac[i].compareTo(bc[i])<0) {
					return -1;
				} else {
					continue;
				}
			}
			return 0;
		} else if(x<75) { // Straight (Won't matter)
			return 0;
		} else if(x<90) { // Flush
			Card[] ac = a.getCards();
			Card[] bc = b.getCards();
			Arrays.sort(ac);
			Arrays.sort(bc);
			for(int i = 3; i>-1; i--) {
				if(ac[i].compareTo(bc[i])>0) {
					return 1;
				} else if(ac[i].compareTo(bc[i])<0) {
					return -1;
				} else {
					continue;
				}
			}
			return 0;
		} else if(x<105) { // Full house
			Card[] ac = a.getCards();
			Card[] bc = b.getCards();
			Arrays.sort(ac);
			Arrays.sort(bc);
			for(int i = 3; i>-1; i--) {
				if(ac[i].compareTo(bc[i])>0) {
					return 1;
				} else if(ac[i].compareTo(bc[i])<0) {
					return -1;
				} else {
					continue;
				}
			}
			return 0;
		} else { //Straight Flush and Royal Flush tying won't matter.
			return 0;
		}
	}
	
	/////////////////////////////////////////////////
	
		public String toString() {
			String x = "| ";
			for(int i = 0; i<cards.length; i++) {
				x+=cards[i].toString()+" | ";
			}
			return x;
		}
	
	/////////////////////////////////////////////////
	
	public int getScore() {
		return score;
	}
	
	/////////////////////////////////////////////////
	
	public Card[] getCards() {
		return cards;
	}

}
