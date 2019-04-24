package ch03_prj3_GradeConverter;

import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		// Welcome statement
		System.out.println("Welcome to the Grade Converter App!");
		System.out.println();
		
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		// Prompt user input
			System.out.print("Enter numerical grade: ");
			int numGrade = sc.nextInt();
			
		
		// Business logic
			String letterGrade = null;
			if (numGrade <= 100 && numGrade >= 88) {
				letterGrade = "A";
			} else if (numGrade <= 87 && numGrade >= 80); {
				letterGrade = "B";
			}
		// Display results
			System.out.println("Letter grade: "+letterGrade);}
			}
	
		// Goodbye statement
			System.out.println("Goodbye!");
		}
