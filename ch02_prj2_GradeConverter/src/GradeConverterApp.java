import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		// Welcome statement
		System.out.println("Welcome to the Grade Converter App!");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			// Prompt for user input
			System.out.print("Enter numerical grade: ");
			int numGrade = sc.nextInt();
			
			// Business logic
			String letGrade = null;
			if (numGrade <= 100 && numGrade >= 88) {
				letGrade = "A";
			} else if (numGrade <= 87 && numGrade >= 80) {
				letGrade = "B";
			} else if (numGrade <= 79 && numGrade >= 67) {
				letGrade = "C";
			} else if (numGrade <= 66 && numGrade >= 60) {
				letGrade = "D";
			} else {
				letGrade = "F";
			}
			
			
			// Display results
			System.out.println("Letter grade: "+letGrade);
			System.out.println();
			System.out.print("Continue?(y/n):  ");
			choice = sc.next();
			System.out.println();
		}
		
		// Goodbye statement
		System.out.println("Thank you for using the Grade Converter App!");

	}

}
