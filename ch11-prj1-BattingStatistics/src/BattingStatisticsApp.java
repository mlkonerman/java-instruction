import java.util.Scanner;

public class BattingStatisticsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Batting Average Calculator!");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter number of times at bat: ");
			int atBats = sc.nextInt();
			System.out.println();
			System.out.println("0=out, 1=single, 2=double, 3=triple, 4=homerun");
			System.out.println();

			int result = 0;
			for (int i = 1; i <= atBats; i++) {
				System.out.print("Result for at-bat " + i + ": ");
				result = sc.nextInt();
				continue;
			}
			for (int i = 1; i <= atBats; i++) {
			int hit;
				if (result == 0) {
					hit = 0;
				} else hit = 1;
			int numberHits = Math.
			int battingAvg = numberHits / atBats;
			System.out.println("Batting average: " + battingAvg);

			System.out.println();
			System.out.print("Another player? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		System.out.println("Thank you for using the Batting Average Calculator. Goodbye!");
	}

}
}
