public class Employee extends Person {

	private String ssn;
	
	public Employee(String first, String last, String ssn) {
		super(first, last);
		this.ssn = ssn;
	}

	public String getSsn() {
		return "xxx-xx-" + ssn.substring(ssn.length() - 4);
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		String name = super.toString();
		return name + "\nSSN: " + getSsn();
	}
}
