import java.util.ArrayList;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager!");
		System.out.println();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {			
			System.out.println("Add a new customer");
			System.out.println();
			String first = Console.getRequiredString("First name: ");
			String last = Console.getRequiredString("Last name: ");
			String number = Console.getRequiredString("Customer number: ");
			Person person = new Customer(first, last, number);
			

			System.out.println();
			System.out.println("You entered a new customer:");
			System.out.println(person.toString());

			choice = Console.getChoiceString("Continue? (y/n): ", "y", "n");
			
		}

		System.out.println("Goodbye!");

	}

}
