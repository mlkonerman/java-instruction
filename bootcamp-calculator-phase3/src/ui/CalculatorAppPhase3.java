package ui;
import java.util.Scanner;

import business.Function;
import util.Console;

public class CalculatorAppPhase3 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator App!");
		System.out.println();
		printMenu();

		Function selectedFunction = new Function();
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int firstEntry = Console.getInt(sc, "Enter the first number: ");
			String selectedOp = Console.getRequiredString(sc, "Please select the type of calculation to perform: ");
			int secondEntry = Console.getInt(sc, "Enter the second number: ");

			switch (selectedOp){
			case "+":
				System.out.println("Answer: "+ selectedFunction.addition(firstEntry, secondEntry));
		    	break;
			case "-":
				System.out.println("Answer: "+ selectedFunction.subtraction(firstEntry, secondEntry));
				break;
			case "*":
				System.out.println("Answer: "+ selectedFunction.multiplication(firstEntry, secondEntry));
				break;
			case "/":
				System.out.println("Answer: "+ selectedFunction.division(firstEntry, secondEntry));
				break;
			case "%":
				System.out.println("Answer: "+ selectedFunction.modulus(firstEntry, secondEntry));
				break;			
			
			}

			
			System.out.println();
			choice = Console.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
			System.out.println();

		}
			System.out.println("Thank you for using the Calculator App. Goodbye!"); 
	}
	
	private static void printMenu() {
		System.out.println("Calculation Menu \n============== \nAddition (+) \nSubtraction (-) "
				+ "\nMultiplication (*) \nDivision (/) \nModulus (%)");
		System.out.println();
	}
	

}