import java.text.NumberFormat;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
		// Welcome statement
		System.out.println("Welcome to the Temperature Converter App!");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// Prompt user input
			System.out.print("Enter degrees in Fahrenheit: ");
			double tempFahr = sc.nextDouble();

			// Business logic
			double tempCels = (tempFahr - 32) * 5 / 9;
			NumberFormat number = NumberFormat.getNumberInstance();
			number.setMaximumFractionDigits(2);
			String tempCelsString = number.format(tempCels);

			// Display results
			System.out.println("Degrees in Celsius = " + tempCelsString);
			System.out.println();
			System.out.print("Continue?(y/n):  ");
			choice = sc.next();
			System.out.println();
		}

		// Goodbye statement
		System.out.println("Thank you for using the Temperature Converter App!");

	}

}
