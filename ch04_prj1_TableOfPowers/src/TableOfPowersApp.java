import java.util.Scanner;

public class TableOfPowersApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Table of Powers!");
		Scanner sc = new Scanner(System.in);
		String choice ="y";
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter a number: ");
			int userEntry = sc.nextInt();
			System.out.println("Number\tSquared\tCubed");
			System.out.println("======================");
			
			for (int i = 1; i <= userEntry; i++) {
				int s = i * i;
				int c = i * i * i;
				System.out.println(i+"\t"+s+"\t"+c);
			}
		
			
			System.out.println("Continue? (y/n): ");
			choice = sc.next();
		}
		

	}

}
