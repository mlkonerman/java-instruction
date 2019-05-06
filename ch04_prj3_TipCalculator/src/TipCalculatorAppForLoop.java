import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorAppForLoop {

	public static void main(String[] args) {
		System.out.println("Welcome to the Tip Calculator!");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			NumberFormat cf = NumberFormat.getCurrencyInstance();
			NumberFormat pf = NumberFormat.getPercentInstance();
			System.out.print("Enter the cost of your meal: ");
			double mealCost = sc.nextDouble();
			System.out.println();
			for (int i = 15; i <= 25; i += 5) {
				double percent = i / 100.0;
				double tip = mealCost * percent;
				double total = mealCost + tip;
				System.out.println(pf.format(percent));
				System.out.println("Tip Amount: " + cf.format(tip));
				System.out.println("Total: " + cf.format(total));
				System.out.println();
			}
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		System.out.println("Thank you for using the Tip Calculator. Goodbye!");

	}

}
