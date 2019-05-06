import java.util.Scanner;

public class DataValidation {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Rectangle Calculator App!");		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			double length = getDoubleWithinRange(sc, "Enter length: ", 0, 100);
			double width = getDoubleWithinRange(sc, "Enter width: ", 0, 100);
			
			// Business logic
			double area = length * width;
			double perimeter = 2 * length + 2 * width;
			
			// Display results
			System.out.println("area = "+area);
			System.out.println("perimeter = "+perimeter);
			
			
			System.out.println("Continue?(y/n)  ");
			choice = sc.next();
		
		}
		
		// Bye
		System.out.println("Goodbye!");
	}
	
	public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			d = getDouble(sc, prompt);
			if (d <= min) {
				System.out.println(
						"Error! Number must be greater than " + min + ".");
			} else if (d >= max) {
				System.out.println(
						"Error! Number must be less than " + max + ".");
			} else {isValid = true;
			
			}
			
		}
	return d;
	}


	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {System.out.println("Error! Invalid Number. Try again.");
		}
		sc.nextLine();	
		}
		return d;
	} }