import java.util.Scanner;

public class DiceRollerNoNewMethods {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller App!");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Roll the dice? (y/n): ");
		String choice = sc.next();
		while(choice.equalsIgnoreCase("y")) {
			String special = "";
			int dieOne = (int) ((Math.random() * 6) + 1);
			int dieTwo = (int) ((Math.random() * 6) + 1);
			int total = dieOne + dieTwo;
				if (total == 12) {
					special = "Boxcars!";
				}
				else if (total == 2) {
					special = "Snake eyes!";
				}
				else special = "";
			System.out.println();
			System.out.println("Die 1: " + dieOne + "\nDie 2: " + dieTwo + "\nTotal: " + total + "\n" + special);
			System.out.println();
			System.out.print("Roll again? (y/n): ");
			choice = sc.next();		
			
				
		}
		System.out.println();
		System.out.println("Thank you for using the Dice Roller. Goodbye!");
	}

}