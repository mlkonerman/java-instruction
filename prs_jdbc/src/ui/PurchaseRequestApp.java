package ui;

import java.util.List;

import business.User;
import db.DAO;
import db.UserDB;
import util.Console;
import util.StringUtils;

public class PurchaseRequestApp {

	private static DAO<User> userDAO = new UserDB();

	public static void main(String[] args) {
		System.out.println("Welcome to the Purchase Request System!");

		displayMenu();
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get input from user
			action = Console.getRequiredString("Enter a command: ");

			if (action.equalsIgnoreCase("list")) {
				// get a list of users and print to screen
				displayAllUsers();
				
				
			} else if (action.equalsIgnoreCase("add")) {
				// add a user
				addUser();
				
			} else if (action.equalsIgnoreCase("del")) {
				// delete a user
				deleteUser();
				
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
		System.out.println("list     - list all users");
		System.out.println("add      - add a user");
		System.out.println("del      - delete a user");
		System.out.println("help     - show this menu");
		System.out.println("exit     - exit the app");
	}
	
	private static void displayAllUsers() {
		System.out.println("USER LIST: ");
		System.out.println("=====================");
		List<User> users = userDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (User u: users) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(u.getId()), 3));
			sb.append(StringUtils.padWithSpaces(u.getUserName(), 20));
			sb.append(StringUtils.padWithSpaces(u.getPassword(), 20));
			sb.append(StringUtils.padWithSpaces(u.getFirstName(), 20));
			sb.append(StringUtils.padWithSpaces(u.getLastName(), 20));
			sb.append(StringUtils.padWithSpaces(u.getPhoneNumber(), 20));
			sb.append(StringUtils.padWithSpaces(u.getEmail(), 50));
			sb.append(StringUtils.padWithSpaces(Boolean.toString(u.isReviewer()), 20));
			sb.append(StringUtils.padWithSpaces(Boolean.toString(u.isAdmin()), 20));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void addUser() {
		String userName = Console.getRequiredString("Enter Username: ");
		String password = Console.getRequiredString("Enter Password: ");
		String firstName = Console.getRequiredString("Enter First Name: ");
		String lastName = Console.getRequiredString("Enter Last Name: ");
		String phoneNumber = Console.getRequiredString("Enter Phone Number: ");
		String email = Console.getRequiredString("Enter Email: ");
		boolean isReviewer = false;
		if(Console.getChoiceString("Is the user a reviewer? (y/n): ", "y", "n").equalsIgnoreCase("y")) {
			isReviewer = true;
		}
		boolean isAdmin = false;
		if(Console.getChoiceString("Is the user an admin? (y/n): ", "y", "n").equalsIgnoreCase("y")) {
			isAdmin = true;
		}

		
		User u = new User(userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		if (userDAO.add(u)) {
			System.out.println("User " + u.getUserName()+ " successfully added.");
		}
		else {
			System.out.println("Error adding user.");
		}
	
	}
	private static void deleteUser() {
		System.out.println("!!! Delete User!!!");
		int id = Console.getInt("Enter User ID to Delete: ");
		//get a product for the code
		User u = userDAO.get(id);
		if (u == null) {
			System.out.println("Invalid code.");
		}
		else {
			if (userDAO.delete(u)) {
				System.out.println("Delete success");
			}
			else {
				System.out.println("Error deleting.");
			}
			
		}
	}

}
