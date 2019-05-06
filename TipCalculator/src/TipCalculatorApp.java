import java.text.NumberFormat;
import java.util.Scanner;


public class TipCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Tip Calculator!");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter the cost of your meal: ");
			double mealCost = sc.nextDouble();
			double fifteenPct = mealCost * .15;
			double twentyPct = mealCost * .20;
			double twentyFivePct = mealCost * .25;
			double firstTotal = mealCost * 1.15;
			double secondTotal = mealCost * 1.20;
			double thirdTotal = mealCost *1.25;
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			System.out.println();
			System.out.println("15%\nTip Amount: " + currency.format(fifteenPct) + 
					"\nTotal amount: " + currency.format(firstTotal));
			System.out.println();
			System.out.println("20%\nTip Amount: " + currency.format(twentyPct) + 
					"\nTotal amount: " + currency.format(secondTotal));
			System.out.println();
			System.out.println("25%\nTip Amount: " + currency.format(twentyFivePct) + 
					"\nTotal amount: " + currency.format(thirdTotal));
			System.out.println();
			System.out.print("Continue?(y/n):  ");
			choice = sc.next();
			System.out.println();
		}
		System.out.println("Thank you for using the Tip Calculator. Goodbye!");

	}

}
