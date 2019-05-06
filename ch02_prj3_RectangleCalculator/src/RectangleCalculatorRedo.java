import java.util.Scanner;

public class RectangleCalculatorRedo {

	public static void main(String[] args) {
		System.out.println("Welcome to the Travel Time Calculator!");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter miles traveled: ");
			int miles = sc.nextInt();
			System.out.print("Enter miles per hour: ");
			int mph = sc.nextInt();
			System.out.println();
			int travelHours = miles / mph;
			double travelMinutes = (miles % mph) / 65 * 60;
			System.out.println("Estimated travel time");
			System.out.println("---------------------");
			System.out.println("Hours: " + travelHours);
			System.out.println("Minutes: " + travelMinutes);
			
			
			
		}
		
		
	}

}
