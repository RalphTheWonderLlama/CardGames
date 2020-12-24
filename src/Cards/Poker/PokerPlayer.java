package Cards.Poker;
import Cards.Valued;

public class PokerPlayer implements Valued, Comparable<PokerPlayer>{
	private boolean folded;
	private int bal;
	private PokerHand hand;
	
	public PokerPlayer(int b, PokerHand h) {
		hand = h;
		bal = b;
		folded = false;
	}
	
	public PokerHand getHand() {
		return hand;
	}
	
	public int getBal() {
		return bal;
	}
	
	public void increaseBal(int a) {
		bal+=a;
	}
	
	public void decreaseBal(int a) {
		bal-=a;
	}
	
	public String toString() {
		return ("Hand: "+hand.toString()+"/n"+"Balance: "+bal);
	}
	
	public void setHand(PokerHand h) {
		hand = h;
	}
	
	public void fold() {
		folded = true;
	}
	
	public void setFold(boolean f) {
		folded = f;
	}
	
	public int getValue() {
		if(folded) {
			return 0;
		}
		return hand.getScore();
	}
	
	public int compareTo(PokerPlayer b) {
		return hand.compareTo(b.getHand());
	}
	
	public boolean isFolded() {
		return folded;
	}
}
