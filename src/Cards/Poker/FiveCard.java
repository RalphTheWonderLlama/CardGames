package Cards.Poker;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FiveCard extends PokerRound{
	public FiveCard(PokerPlayer[] p, int minRaise) {
		super(p, minRaise);
	}

	public boolean playRound() {
		return RoundEnd();
	}
}
