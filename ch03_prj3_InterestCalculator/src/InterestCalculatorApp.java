import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		// Welcome statement
		System.out.println("Welcome to the Interest Calculator App!");
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// Prompt for user input
			System.out.println("Enter loan amount: ");
			String loanAmtStr = sc.next();
			BigDecimal loanAmt = new BigDecimal(loanAmtStr);
			loanAmt = loanAmt.setScale(2, RoundingMode.HALF_UP);
			
			System.out.println("Enter interest rate: ");
			
			String intRateStr = sc.next();
			BigDecimal intRate = new BigDecimal(intRateStr);
			
			// Business logic
			BigDecimal interestAmt = loanAmt.multiply(intRate);
			
			// Display results
			NumberFormat cf = NumberFormat.getCurrencyInstance();
			cf.setRoundingMode(RoundingMode.HALF_UP);
			NumberFormat pf = NumberFormat.getPercentInstance();
			pf.setMaximumFractionDigits(3);
			pf.setMinimumFractionDigits(3);
			
			System.out.println("Loan amount: "+cf.format(loanAmt));
			System.out.println("Interest rate: "+pf.format(intRate));
			System.out.println("Interest: "+cf.format(interestAmt));
			
			System.out.println("Continue? y/n: ");
			choice = sc.next();
		}
			
		// Goodbye statement
		
		System.out.println("Thank you for using the Interest Calculator App!");
	}

}
