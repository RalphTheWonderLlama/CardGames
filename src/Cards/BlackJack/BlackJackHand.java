package Cards.BlackJack;
import java.util.ArrayList;

import Cards.Card;

public class BlackJackHand {
	private ArrayList<Card> cards;
	public BlackJackHand(Card[] c) {
		cards = new ArrayList<Card>();
		for(Card d : c) {
			cards.add(d);
		}

	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	public boolean busted() {
		return this.value() == -1;
	}
	
	public int number() {
		int numb = 0;
		for(Card c : cards) {
			switch (c.getNumber()) {
			case 11:
				numb+=10;
				break;
			case 12:
				numb+=10;
				break;
			case 13:
				numb+=10;
				break;
			case 14:
				numb+=11;
				break;
			default:
				numb+=c.getNumber();
				break;
				
			}	
		}
		return numb;
	}
	
	public int value() {
		if(this.number() > 21) {
			int numbAces = 0;
			for(Card c : cards) {
				if(c.getNumber() == 14) {
					numbAces++;
				}
			}
			int numb = this.number();
			for(int i = 1; i <=numbAces; i++) {
				if(numb>21) {
					numb-=10;
				}
			}
			if(numb > 21) {
				return -1;
			} else {
				return numb;
			}
		} else if(this.number() == 21 && cards.size() == 2) {
			return 35;
		} else {
			return this.number();
		}
		
	}
	
	public String toString() {
		String x = "";
		for(int i = 0; i<cards.size(); i++) {
			x+=cards.get(i)+", ";
		}
		return x;
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
}
