import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorAppDavid {

	public static void main(String[] args) {
		System.out.println("Tip Calculator");

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			// Number Formatting
			NumberFormat cf = NumberFormat.getCurrencyInstance();
			NumberFormat pf = NumberFormat.getPercentInstance();

			// User input
			System.out.print("Cost of meal: ");
			double cost = sc.nextDouble();
			System.out.println();

			// Display and Math
			// For loop for numbers 15, 20, and 25
			for (int i = 15; i <= 25; i += 5) {
				
				// Convert incremental to a double and a percentage
				double percent = i / 100.0;
				
				// Calculate tip and total
				double tip = cost * percent;
				double total = cost + tip;
				
				// Format and display
				System.out.println(pf.format(percent));
				System.out.println("Tip amount:   " + cf.format(tip));
				System.out.println("Total amount: " + cf.format(total));
				System.out.println();
			}
			
			// Loop question
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();

		}
		System.out.println("Bye!");
		sc.close();
	}
}