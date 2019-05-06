import java.util.Scanner;

public class GradeConverterRedo {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter!");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter numerical grade: ");
			int numGrade = sc.nextInt();
			String letterGrade = "";
			if (numGrade <= 100 && numGrade >= 88) {
				letterGrade = "A";
			} else if (numGrade <= 87 && numGrade >= 80) {
				letterGrade = "B";
			} else if (numGrade <= 79 && numGrade >= 67) {
				letterGrade = "C";
			} else if (numGrade <= 66 && numGrade >= 60) {
				letterGrade = "D";
			} else {
				letterGrade = "F";
			}
			System.out.println("Letter grade: " + letterGrade);
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();

		}
		System.out.println("Thank you for using the Letter Grade Converter. Goodbye!");

	}

}
