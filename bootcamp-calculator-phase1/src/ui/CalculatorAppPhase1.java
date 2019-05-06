package ui;

import java.util.Scanner;

public class CalculatorAppPhase1 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator App!");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {

			// Select an operation
			System.out.println(
					"Addition: (+) \nSubtraction: (-) \nMultiplication: (*) " + "\nDivision: (/) \nModulus: (%)");
			System.out.print("\nPlease select an operation: "); 
			String operation = sc.next(); //Why does user have to press Enter twice to get to next prompt?
			System.out.print("Enter a number: "); 
			int firstEntry = sc.nextInt(); //Why does user have to press Enter twice to get to next prompt?
			System.out.print("Enter another number: ");
			int secondEntry = sc.nextInt();
			double result = 0.0;
			String calcType = "";

			if (operation.equalsIgnoreCase("+")) {
				result = firstEntry + secondEntry;
				calcType = "+";
			} else if (operation.equalsIgnoreCase("-")) {
				result = firstEntry - secondEntry;
				calcType = "-";
			} else if (operation.equalsIgnoreCase("*")) {
				result = firstEntry * secondEntry;
				calcType = "*";
			} else if (operation.equalsIgnoreCase("/")) {
				result = (double)(firstEntry / secondEntry); // Why does this work in Phase 2 to get precise decimal answer and not in Phase 1?
				calcType = "/";
			} else if (operation.equalsIgnoreCase("%")) {
				result = firstEntry % secondEntry;
				calcType = "%";
			}

			System.out.println(firstEntry + " " + calcType + " " + secondEntry + " = " + result);

			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}

		System.out.println("Thank you for using the Calculator App. Goodbye!");

	}

}