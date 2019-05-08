package ui;

import business.Calculator;
import util.Console;

public class CalculatorApp {

	public static void main(String[] args) {
		// requirements:
		// 1) Provide basic calculator functions: +,-,*,/,%
		// 2) Prompt user for two numbers
		// 3) Perform calculation
		// 4) Display result

		System.out.println("Welcome to the Calculator App!");

		double result = 0.0;
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int a = Console.getIntWithinRange("Enter 1st number: ", 0, Integer.MAX_VALUE);
			String opr = Console.getRequiredString("Operation (+ - * / %)?");
			int b = Console.getIntWithinRange("Enter 2nd number: ", 0, Integer.MAX_VALUE);
			Calculator calc = new Calculator(a,b);
			if (opr.equals("+")) {
				result = calc.add();
			} else if (opr.equals("-")) {
				result = calc.subtract();
			} else if (opr.equals("*")) {
				result = calc.multiply();
			} else if (opr.equals("/")) {
				result = calc.divide();
			} else if (opr.equals("%")) {
				result = calc.modulus();
			}
			System.out.println("Result: " + result);
			choice = Console.getRequiredString("Continue?(y/n): ");


		}
		System.out.println("Goodbye!");

	}

	
}
