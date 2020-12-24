package Cards;

public class Card implements Comparable<Card>{
	private int numb; // Jack = 11, Queen = 12, King = 13, Ace = 1;
	private int suit; // 0 = Hearts, 1 = Clubs, 2 = Diamonds, 3 = Spades
	
	public Card(int n, int s) {
		if(n<=13 && n>=1)
			numb = n;
		else
			throw new IllegalArgumentException("Second parameter must be between 1 and 13");
		if(s>=0 && s<=3)
			suit = s;
		else
			throw new IllegalArgumentException("Second parameter must be between 0 and 3");
	}
	
	public int compareTo(Card that) {
		return this.getNumber()-that.getNumber();
	}

	
	public int getNumber() {
		if(numb == 1) {
			return 14;
		} else {
			return numb;
		}
	}
	
	public int getSuit() {
		return suit;
	}
	
	public String toString() {
		if(numb>=2 && numb<=10) {
			if(suit == 0)
				return numb+" of Hearts";
			else if(suit == 1)
				return numb+" of Clubs";
			else if(suit == 2)
				return numb+" of Diamonds";
			else
				return numb+" of Spades";
		} else if(numb == 1) {
			if(suit == 0)
				return "Ace of Hearts";
			else if(suit == 1)
				return "Ace of Clubs";
			else if(suit == 2)
				return "Ace of Diamonds";
			else
				return "Ace of Spades";
		} else if(numb == 11) {
			if(suit == 0)
				return "Jack of Hearts";
			else if(suit == 1)
				return "Jack of Clubs";
			else if(suit == 2)
				return "Jack of Diamonds";
			else
				return "Jack of Spades";
		} else if(numb == 12) {
			if(suit == 0)
				return "Queen of Hearts";
			else if(suit == 1)
				return "Queen of Clubs";
			else if(suit == 2)
				return "Queen of Diamonds";
			else
				return "Queen of Spades";
		} else{
			if(suit == 0)
				return "King of Hearts";
			else if(suit == 1)
				return "King of Clubs";
			else if(suit == 2)
				return "King of Diamonds";
			else
				return "King of Spades";
		}
	}
}
