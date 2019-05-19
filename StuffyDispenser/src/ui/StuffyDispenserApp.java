package ui;

import java.util.List;

import business.Stuffy;
import db.DAO;
import db.StuffyDB;
import util.Console;
import util.StringUtils;


public class StuffyDispenserApp {

	private static DAO<Stuffy> stuffyDAO = new StuffyDB();

	public static void main(String[] args) {
		System.out.println("Welcome to the Stuffy Dispenser!");

		displayMenu();
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get input from user
			action = Console.getRequiredString("Enter a command: ");

			if (action.equalsIgnoreCase("list")) {
				// get a list of products and print to screen
				displayAllStuffies();
				
				
			} else if (action.equalsIgnoreCase("add")) {
				// add a product
				addStuffy();
				
			} else if (action.equalsIgnoreCase("del")) {
				// delete a product
				deleteStuffy();
				
			}

			else if (action.equalsIgnoreCase("help")) {
				displayMenu();
			} 
			else if (!action.equalsIgnoreCase("exit")) {
				System.out.println("Invalid command.");
			}


		}
		System.out.println("Goodbye!");
	}

	public static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("======================");
		System.out.println("list     - list all stuffies");
		System.out.println("add      - add a stuffy");
		System.out.println("del      - delete a stuffy");
		System.out.println("help     - show this menu");
		System.out.println("exit     - exit the app");
	}
	
	private static void displayAllStuffies() {
		System.out.println("Stuffy LIST: ");
		System.out.println("=====================");
		List<Stuffy> stuffies = stuffyDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Stuffy s: stuffies) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(s.getId()), 3));
			sb.append(StringUtils.padWithSpaces(s.getType(), 20));
			sb.append(StringUtils.padWithSpaces(s.getColor(), 20));
			sb.append(StringUtils.padWithSpaces(s.getSize(), 20));
			sb.append(s.getLimbs());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void addStuffy() {
		String type = Console.getRequiredString("Enter Stuffy Type: ");
		String color = Console.getRequiredString("Enter Stuffy Color: ");
		String size = Console.getRequiredString("Enter Stuffy Size: ");
		int limbs = Console.getInt("Enter Stuffy's Number of Limbs: ");
		
		Stuffy s = new Stuffy(type, color, size, limbs);
		if (stuffyDAO.add(s)) {
			System.out.println("Stuffy " + s.getType()+ " successfully added.");
		}
		else {
			System.out.println("Error adding product.");
		}
	
	}
	private static void deleteStuffy() {
		System.out.println("!!! Delete Stuffy!!!");
		int ID = Console.getInt("Enter stuffy ID to delete: ");
		//get a product for the code
		Stuffy s = stuffyDAO.get(ID);
		if (s == null) {
			System.out.println("Invalid code.");
		}
		else {
			if (stuffyDAO.delete(s)) {
				System.out.println("Delete success");
			}
			else {
				System.out.println("Error deleting.");
			}
			
		}
	}

}
