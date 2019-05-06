import java.util.Scanner;

public class ForLoopPractice {

	public static void main(String[] args) {
		System.out.println("Welcome to the Table of Doubles!");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter a positive whole number: ");
			int userEntry = sc.nextInt();
			System.out.println();
			System.out.println("Number" + "\t\tDoubled");
			System.out.println("======" + "\t\t=======");
			for(int i = 1; i <= userEntry; i += 1) {
				int twice = i * 2;
				System.out.println(i + "\t\t" + twice);
			}
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		System.out.println("Goodbye!");
		

	}

}
