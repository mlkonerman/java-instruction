
import java.util.Scanner;

public class NameParserApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a name: ");
		System.out.println();
		String name = sc.nextLine();
		name = name.trim();

		int spaceOccurence1 = name.indexOf(" ");
		if (spaceOccurence1 == -1) {
			System.out.println("Error: Invalid format.");
		} else {
			int spaceOccurence2 = name.indexOf(" ", spaceOccurence1 + 1);
			if (spaceOccurence2 == -1) {
				String firstName = name.substring(0, spaceOccurence1);
				String lastName = name.substring(spaceOccurence1 + 1);
				System.out.println("First name: " + firstName);
				System.out.println("Last name: " + lastName);
			} else {
				int spaceOccurence3 = name.indexOf(" ", spaceOccurence2 + 1);
				if (spaceOccurence3 == -1) {
					String firstName = name.substring(0, spaceOccurence1);
					String middleName = name.substring(spaceOccurence1 + 1, spaceOccurence2);
					String lastName = name.substring(spaceOccurence2 + 1);
					System.out.println("First name: " + firstName);
					System.out.println("Middle name: " + middleName);
					System.out.println("Last name: " + lastName);
				} else {
					System.out.println("Error: Invalid format.");
				}
			
			}
		}

	}
}
