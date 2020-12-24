package Cards;

import Cards.Poker.PokerHand;

public class CardDeck {
	Card[] deck;
	int spot;
	
	//////////////////
	// Constructors //
	//////////////////
	
	public CardDeck() { // Is shuffled
		deck = new Card[52];
		for(int s = 0; s<4; s++) {
			for(int n = 1; n<14; n++) {
				int x = (int)(Math.random()*52);
				while(deck[x] != null) {
					x = (int)(Math.random()*52);
				}
				deck[x] = new Card(n, s);
			}
		}
		spot = -1;
	}
	
	public CardDeck(boolean shuffled) {
		deck = new Card[52];
		if(shuffled){
			for(int s = 0; s<4; s++) {
				for(int n = 1; n<14; n++) {
					int x = (int)(Math.random()*52);
					while(deck[x] != null) {
						x = (int)(Math.random()*52);
					}
					deck[x] = new Card(n, s);
				}
			}
		} else {
			int x = 0;
			for(int s = 0; s<4; s++) {
				for(int n = 1; n<14; n++) {
					deck[x] = new Card(n, s);
					x++;
				}
			}
		}
		spot = -1;
	}
	
	public CardDeck(int numbDecks, boolean shuffled) {
		if(numbDecks == 0) {
			throw new IllegalArgumentException("You must have at least 1 deck");
		}
		deck = new Card[52*numbDecks];
		for(int i = 0; i<numbDecks; i++) {
			if(shuffled){
				for(int s = 0; s<4; s++) {
					for(int n = 1; n<14; n++) {
							int x = (int)(Math.random()*52*numbDecks);
						while(deck[x] != null) {
							x = (int)(Math.random()*52*numbDecks);
						}
						deck[x] = new Card(n, s);
					}
				}
		} else {
			int x = i*52;
				for(int s = 0; s<4; s++) {
					for(int n = 1; n<14; n++) {
						deck[x] = new Card(n, s);
						x++;
					}
				}
			}
		}
		spot = -1;
	}

	/////////////////
	// getNextCard //
	/////////////////
	
	public Card getNextCard() {
		spot++;
		if(spot>deck.length) {
			throw new IllegalArgumentException("Out of Cards");
		}
		return deck[spot];
	}
	
	public Card getNextCard(boolean reshuffle) {
		spot++;
		if(spot>deck.length && reshuffle ) {
			this.shuffle();
			spot = 0;
		}
		return deck[spot];
	}
	
	public void shuffle() {
		deck = new Card[deck.length];
		for(int i = 0; i<deck.length/52; i++) {
			for(int s = 0; s<4; s++) {
				for(int n = 1; n<14; n++) {
					int x = (int)(Math.random()*deck.length);
						while(deck[x] != null) {
							x = (int)(Math.random()*deck.length);
						}
						deck[x] = new Card(n, s);
				}
			}
		}
		spot = -1;
	}
	
	public void printDeck() {
		for(int i = 0; i<deck.length; i++) {
			System.out.println(deck[i]);
		}
	}
	public PokerHand[] deal(int numbHands) {
		Card[][] s = new Card[numbHands][5];
		for(int i = 0; i<5; i++) {
			for(int n = 0; n<numbHands; n++) {
				s[n][i] = this.getNextCard();
			}
		}
		PokerHand[] b = new PokerHand[numbHands];
		for(int i = 0; i < numbHands; i++) {
			b[i] = new PokerHand(s[i]);
		}
		return b;
	}
	public void reshuffle() {
		this.shuffle();
		spot = -1;
	}
	
	public int numbRemainingCards() {
		return deck.length - spot - 1;
	}

}
