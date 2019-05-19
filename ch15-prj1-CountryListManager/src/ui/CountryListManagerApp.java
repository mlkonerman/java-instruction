package ui;

import java.util.List;

import business.Country;
import business.CountryIO;
import util.Console;

public class CountryListManagerApp {

	public static void main(String[] args) {
		CountryIO countries = new CountryIO();
		countries.createTextFile();

		System.out.println("Country List Manager");

		displayMenu();
		String action = "";
		while (!action.equalsIgnoreCase("3")) {
			// get input from user
			action = Console.getRequiredString("Enter menu number: ");

			if (action.equalsIgnoreCase("1")) {
				// get a list of products and print to screen
				displayAllCountries();

			} else if (action.equalsIgnoreCase("2")) {
				// add a product
				addCountry();

			} else if (!action.equalsIgnoreCase("3")) {
				System.out.println("Invalid command.");
			} 
			
			

		}
		System.out.println("Bye");
	}

	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("======================");
		System.out.println("1     - List countries");
		System.out.println("2     - Add a country");
		System.out.println("3     - Exit the app");

	}

	private static void displayAllCountries() {
		System.out.println("COUNTRY LIST: ");
		System.out.println("=====================");
		List<Country> countries = CountryIO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Country c : countries) {
			sb.append(c.getName());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void addCountry() {
		String name = Console.getRequiredString("Enter country name: ");

		Country c = new Country(name);
		if (CountryIO.add(c)) {
			System.out.println(c.getName() + " successfully added.");
		} else {
			System.out.println("Error adding country.");
		}

	}

}
