import java.util.Scanner;

public class TableOfPowersTable {

	public static void main(String[] args) {
		System.out.println("Welcome to the Table of Powers!");
		Scanner sc = new Scanner(System.in);
		String choice ="y";
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter a number: ");
			int userEntry = sc.nextInt();
			
			String table = "";
			String row = "";
			String header = "Number\tSquared\tCubed\n";
			
			table += header;
			header = "======\t======\t======\t\n";
			table += header;
			
			
			for (int i = 1; i <= userEntry; i++) {
				int s = i * i;
				int c = i * i * i;
				row = i+"\t"+s+"\t"+c+"\n";
				table += row;
			}
		
			System.out.println(table);
			System.out.println("Continue? (y/n): ");
			choice = sc.next();
		}
		

	}

}