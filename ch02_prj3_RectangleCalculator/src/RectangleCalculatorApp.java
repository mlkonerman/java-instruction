import java.util.Scanner;

public class RectangleCalculatorApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Rectangle Calculator App!");		
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// Prompt for user input
			System.out.print("Enter length: ");
			double length = sc.nextDouble();
			System.out.print("Enter width: ");
			double width = sc.nextDouble();
			
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
		System.out.println("Bye!");
	}

}
