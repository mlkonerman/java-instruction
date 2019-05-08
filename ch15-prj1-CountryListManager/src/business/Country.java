package business;
public class Country {

	private String name;
	
	public Country() {
		name = "";
	}

	// we wrote this one in class
	public Country(String inName) {
		name = inName;
		
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Country [name=" + name + "]";
	}
	
	public static void aStaticMethod() {
		System.out.println("an arbitrary static method");
	}






}
