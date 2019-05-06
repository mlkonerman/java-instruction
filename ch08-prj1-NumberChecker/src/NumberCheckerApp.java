public class NumberCheckerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Odd/Even Checker!");
		System.out.println();

		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			int i = Console.getInt("Enter an integer: ");
			if (i % 2 == 0) {
				System.out.println("The number " + i + " is even.");
			} else {
				System.out.println("The number " + i + " is odd.");
			}
			choice = Console.getString("Continue? (y/n): ");

		}

		System.out.println("Thank you for using the Odd/Even Checker. Goodbye!");

	}

}
