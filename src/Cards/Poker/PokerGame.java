package Cards.Poker;
import java.util.Scanner;

public class PokerGame {
	public static void main(String[] Args) {
		int[] settingValues = getSettingValues(); // 0 is numb players, 1 is starting bal, 2 is min raise value
		PokerPlayer[] players = SetupPlayers(settingValues[0], settingValues[1]);
		boolean playAgain = true;	
		FiveCard game = new FiveCard(players, settingValues[2]);
		while(playAgain) {
			playAgain = game.playRound();
		}
		
	}
	public static PokerPlayer[] SetupPlayers(int numbPlayers, int bal) {
		PokerPlayer[] p = new PokerPlayer[numbPlayers];
		for(int i = 0; i<numbPlayers; i++) {
			p[i] = new PokerPlayer(bal, null);
		}
		return p;
	}
	public static int[] getSettingValues() {
//		int[] values = new int[3];
//		System.out.println("Please enter the number of players.");
//		Scanner ky = new Scanner(System.in);
//		values[0] = ky.nextInt();
//		System.out.println("Please enter a starting balance for all players.");
//		values[1] = ky.nextInt();
//		System.out.println("Please enter the minimum raise value.");
//		values[2] = ky.nextInt();
//		ky.nextLine();
		int[] values = {3, 300, 10};
		return values; 
	}
	
	
}
