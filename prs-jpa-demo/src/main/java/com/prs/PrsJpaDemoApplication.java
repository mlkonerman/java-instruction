package com.prs;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.Product;
import com.prs.business.PurchaseRequest;
import com.prs.business.PurchaseRequestLineItem;
import com.prs.business.User;
import com.prs.business.Vendor;
import com.prs.db.ProductDB;
import com.prs.db.PurchaseRequestDB;
import com.prs.db.PurchaseRequestLineItemDB;
import com.prs.db.UserDB;
import com.prs.db.VendorDB;
import com.prs.util.Console;
import com.prs.util.StringUtils;

@SpringBootApplication
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		System.out.println("Hello!");

		displayMenu();
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			// get input from user
			action = Console.getRequiredString("Enter a command: ");

			if (action.equalsIgnoreCase("users")) {
				// list users
				List<User> users = UserDB.getAll();
				System.out.println(users.toString());

			} else if (action.equalsIgnoreCase("vendors")) {
				// list vendors
				List<Vendor> vendors = VendorDB.getAll();
				System.out.println(vendors.toString());

			} else if (action.equalsIgnoreCase("products")) {
				// list products
				List<Product> products = ProductDB.getAll();
				System.out.println(products.toString());
				displayAllProducts();

			} else if (action.equalsIgnoreCase("requests")) {
				// list purchase requests
				List<PurchaseRequest> purchaseRequests = PurchaseRequestDB.getAll();
				System.out.println(purchaseRequests.toString());

			} else if (action.equalsIgnoreCase("LineItems")) {
				// list purchase request line items
				List<PurchaseRequestLineItem> prli = PurchaseRequestLineItemDB.getAll();
				System.out.println(prli.toString());

			} else if (action.equalsIgnoreCase("help")) {
				displayMenu();
			} else if (action.equalsIgnoreCase("test")) {
				List<Product> products = ProductDB.getAll();
				System.out.println(products);
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
		System.out.println("users     - list all users");
		System.out.println("vendors   - list all vendors");
		System.out.println("products  - list all products");
		System.out.println("requests  - list all purchase requests");
		System.out.println("lineitems - list all purchase request line items");
		System.out.println("help      - show this menu");
		System.out.println("exit      - exit the app");
	}
	
	private static void displayAllProducts() {
		System.out.println("PRODUCT LIST: ");
		System.out.println("=====================");
		List<Product> products = ProductDB.getAll();
		StringBuilder sb = new StringBuilder();
		for (Product p : products) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(p.getId()), 3));
			sb.append(StringUtils.padWithSpaces(p.getVendor().getName(), 20));
			sb.append(StringUtils.padWithSpaces(p.getPartNumber(), 20));
			sb.append(StringUtils.padWithSpaces(p.getName(), 75));
			sb.append(StringUtils.padWithSpaces(Double.toString(p.getPrice()), 10));
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}


}