import java.util.Scanner;

public class NameParserAppSol {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        System.out.println();
        name = name.trim(); //Make sure the application works even if the user enters
        					//one or more spaces before or after the name.
        
        int firstSpaceOccurence = name.indexOf(" ");
        if (firstSpaceOccurence == -1) {
            System.out.println("Name not in valid format."); //If the user enters
            														//fewer than two words
        }
        else {
            int secondSpaceOccurence = name.indexOf(" ", firstSpaceOccurence + 1); //code that separates the name into
                                                        // two strings
            if (secondSpaceOccurence == -1) {
                String firstName = name.substring(0, firstSpaceOccurence); //
                String lastName = name.substring(firstSpaceOccurence + 1);
                System.out.println("First name:  " + firstName);
                System.out.println("Last name:   " + lastName);  
            }
            else {
                int thirdSpaceOccurence = name.indexOf(" ", secondSpaceOccurence + 1); //code that separates the name into
                											//three strings
                if (thirdSpaceOccurence == -1) {
                    String firstName = name.substring(0, firstSpaceOccurence);
                    String middleName = name.substring(firstSpaceOccurence + 1, secondSpaceOccurence);
                    String lastName = name.substring(secondSpaceOccurence + 1);
                
                    System.out.println("First name:   " + firstName);
                    System.out.println("Middle name:  " + middleName);
                    System.out.println("Last name:    " + lastName);   
                }
                else {
                    System.out.println("Name not in valid format."); //If the user enters
                    														//more than three
                    														//words
                }
            }
        }
    }
}