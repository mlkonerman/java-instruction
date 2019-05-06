import java.text.NumberFormat;

public class MonthSelectorApp {

    public static void main(String[] args) {
        System.out.println("Monthly Sales\n");
        
        // declare monthNames and monthSales arrays

        String[] monthName = new String[12];
        
        monthName[0] = "January";
        monthName[1] = "February";
        monthName[2] = "March";
        monthName[3] = "April";
        monthName[4] = "May";
        monthName[5] = "June";
        monthName[6] = "July";
        monthName[7] = "August";
        monthName[8] = "September";
        monthName[9] = "October";
        monthName[10] = "November";
        monthName[11] = "December";
        
        double [] monthSales = new double[12];
        
        monthSales[0] = 2749.57;
        monthSales[1] = 2893.40;
        monthSales[2] = 1784.58;
        monthSales[3] = 7926.50;
        monthSales[4] = 1958.34;
        monthSales[5] = 1350.49;
        monthSales[6] = 4587.30;
        monthSales[7] = 2958.34;
        monthSales[8] = 3279.62;
        monthSales[9] = 3005.50;
        monthSales[10] = 2609.90;
        monthSales[11] = 3094.10;

        // get currency formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        
        		
        		
        
        // get one or more months
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            int monthNumber = Console.getInt("Enter month number: ");
            
            // validate input
            if (monthNumber < 1 || monthNumber > monthName.length) {
                Console.displayLine("Invalid month number. Try again.");
                continue;                
            }
            
            // get the index number for the month      
            // and display the month name and sales            
            System.out.println("Sales for " + monthName[monthNumber] + ": " + monthSales[monthNumber]);

            // check if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }
        
        // display the total sales for the year
//        double total = 0.0;
//        for (int i = 0; i < monthSales.length; i++) {
//        	total += monthSales[i];
        
        double total = 0.0;
        for (double monthSale : monthSales) {
        	total += monthSale;
        }
        System.out.println("Total sales: " + total);
        
        Console.displayLine();
    }    

}
