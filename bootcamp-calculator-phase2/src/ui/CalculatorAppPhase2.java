package ui;


import java.util.Scanner;


import util.Console;


public class CalculatorAppPhase2 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator App!");
		System.out.println();
		printMenu();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int firstNum = Console.getInt(sc, "Enter a number: ");
			String selectedOp = Console.getRequiredString(sc, "Enter the calculation type: ");
			int secondNum = Console.getInt(sc, "Enter a number: ");
			double result = 0.0;

			if (selectedOp.equals("+")) {
				result = firstNum + secondNum;
			} else if (selectedOp.equals("-")) {
				result = firstNum - secondNum;
			} else if (selectedOp.equals("*")) {
				result = firstNum * secondNum;
			} else if (selectedOp.equals("/")) {
				result = (double)firstNum / secondNum;
			} else if (selectedOp.equals("%")) {
				result = firstNum % secondNum;
			}

			System.out.println("Answer: " + result);
			System.out.println();
			choice = Console.getChoiceString(sc, "Continue? (y/n): ", "y", "n");

		}
		System.out.println("Thank you for using the Calculator App. Goodbye!");
	}
	
	private static void printMenu() {
		System.out.println("Calculation Menu \n============== \nAddition (+) \nSubtraction (-) "
				+ "\nMultiplication (*) \nDivision (/) \nModulus (%)");
		System.out.println();
	}
	

}
