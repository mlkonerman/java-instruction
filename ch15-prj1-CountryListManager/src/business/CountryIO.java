package business;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;



public class CountryIO {
	public void createTextFile() {
		// String dirString = "c:/Repos/java-instruction/ch15-prj1-CountryListManager";
		// String fileString = "countries.txt";
		// Path filePath = Paths.get(dirString, fileString);
		Path countriesPath = Paths.get("countries.txt");
		File countriesFile = countriesPath.toFile();
		if (Files.notExists(countriesPath)) {
			try {
				Files.createFile(countriesPath);
			} catch (IOException e) {

				e.printStackTrace();
			}
			System.out.println(countriesFile.getName() + " successfully created!");
		} else {
			System.out.println(countriesFile.getName() + " NOT created.");
		}
	}

	private static List<Country> countries = null; // list that will store products
	private static Path countriesPath = null;
	private static File countriesFile = null;
	private static final String FIELD_SEP = "\t";

	public CountryIO() { //constructor that will be called when creating new instance
			// define the path to the file
			countriesPath = Paths.get("countries.txt");
			// define the file
			countriesFile = countriesPath.toFile();
			// initialize our list of countries
			countries = getAll();
		}

	public Country getName(String name) {
		for (Country c : countries) {
			if (c.getName().equalsIgnoreCase(name)) {
				// that's our country!
				return c;
			}
		}
		return null;
	}

	public static List<Country> getAll() {
		if (countries != null) {
			return countries;
		}

		countries = new ArrayList<>();
		if (Files.exists(countriesPath)) {
			try (BufferedReader in = new BufferedReader(new FileReader(countriesFile))) {
				// read a line from countries.txt
				String line = in.readLine();
				while (line != null) {
					String[] fields = line.split(FIELD_SEP);
					String name = fields[0];
					// create instance of product from line
					Country c = new Country(name);
					// add that product to our list of products
					countries.add(c);

					line = in.readLine();
				}

			}
			// this was auto-generated, IOException will handle
//				catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println(countriesPath.toAbsolutePath() + " does not exist.");
			return null;

		}
		return countries;

	}

	public static boolean add(Country t) {
		countries.add(t);
		return saveAll();

	}

	public boolean update(Country t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Country t) {
		countries.remove(t);
		return saveAll();
	}

	// when processing text files, we will re-save the entire file every time we
	// add/update/delete
	private static boolean saveAll() {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(countriesFile)))) {
			// loop through products list and write a record for every product
			for (Country c : countries) {
				out.println(c.getName() + FIELD_SEP);
			}
			return true;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}
	
}
