package wat;

import java.util.Random;

public class Dice {
	private static Random r = new Random();
	
	public static int rollDice(int number, int sides) {
		int sum = 0;
		for (int i = 0; i < number; i++) {
			sum += r.nextInt(sides) + 1;
		}
		return sum;
	}
}
