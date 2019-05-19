package ui;

import java.util.ArrayList;
import java.util.List;

import business.Contact;
import business.TestContact;

public class ContactApp {

	public static void main(String[] args) {
		List<Contact> contacts = new ArrayList<>();

		System.out.println("Welcome!");
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));

		// No Lambda: Which contacts have no email address?
		List<Contact> contactsWithoutEmail = new ArrayList<>();
		for (Contact c : contacts) {
			// does this contact match the criteria?
			if (c.getEmail() == null) {
				contactsWithoutEmail.add(c);
			}
		}
		System.out.println("Contacts with no email (no lamda): ");
		for (Contact c : contactsWithoutEmail) {
			System.out.println(c);
		}

		//No Lambda: Which contacts have no phone number?
		List<Contact> contactsWithoutPhone = new ArrayList<>();
		for (Contact c : contacts) {
			// does this contact match the criteria?
			if (c.getPhone() == null) {
				contactsWithoutPhone.add(c);
			}
		}
		System.out.println("Contacts with no phone (no lambda): ");
		for (Contact c : contactsWithoutPhone) {
			System.out.println(c);

		}
		
		System.out.println("Lambdas!!!!!!");
		System.out.println("Contacts with no phone: ");
		contactsWithoutPhone = filterContacts(contacts,	c-> c.getPhone()== null);
		
		for (Contact c: contactsWithoutPhone) {
			System.out.println(c);
		}
		
		System.out.println("Contacts with no email (no lambda): ");
		for (Contact c : contactsWithoutEmail) {
			System.out.println(c);

		}
		
		System.out.println("Lambdas!!!!!!");
		System.out.println("Contacts with no email: ");
		contactsWithoutEmail = filterContacts(contacts,	c-> c.getEmail()== null);
		
		for (Contact c: contactsWithoutEmail) {
			System.out.println(c);
		}
		
		System.out.println("Goodbye!");

	}
	
	private static List<Contact> filterContacts(List<Contact> contacts, TestContact condition) {
		List <Contact> filteredContacts = new ArrayList<>();
		for (Contact c: contacts) {
			if (condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		return filteredContacts;
	}
}
