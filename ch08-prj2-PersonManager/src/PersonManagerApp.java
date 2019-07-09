import java.util.ArrayList;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager!");
		System.out.println();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {			
			String personType = Console.getChoiceString("Create customer or employee? (c/e): ", "c", "e");
			String first = Console.getRequiredString("First name: ");
			String last = Console.getRequiredString("Last name: ");
			Person person;
			if (personType.equalsIgnoreCase("c")) {
				String number = Console.getRequiredString("Customer number: ");
				person = new Customer(first, last, number);
			} else {
				String ssn = Console.getRequiredString("SSN: ");
				person = new Employee(first, last, ssn);
			}

			Class c = person.getClass();

			System.out.println();
			System.out.println("You entered a new " + c.getName() + ":");
			System.out.println(person.toString());

			Console.getChoiceString("Continue? (y/n): ", "y", "n");
		}

		System.out.println("Goodbye!");

	}

}
