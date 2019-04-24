import java.util.Scanner;

public class StudentRegistrationApp {

	public static void main(String[] args) {
		// Welcome statement
		System.out.println("Welcome to the Student Registration App!");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		// Prompt for user input
		System.out.print("Enter first name: ");
		String first = sc.nextLine();
		System.out.print("Enter last name: ");
		String last = sc.nextLine();
		System.out.print("Enter year of birth: ");
		int birthyear = sc.nextInt();
		// Business logic
		String fullname = first + (" ") + last;
		String password = first + "*" + birthyear;
		// Display results
		System.out.println();
		System.out.println("Welcome " + first + " " + last + "!");
		System.out.println("Your registration is complete.");
		System.out.println("Your temporary password is " + password);

		// Bye statement
		System.out.println("Thank you for using the Student Registration App!");

	}

}
