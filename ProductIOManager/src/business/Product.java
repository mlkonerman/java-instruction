package business;

public class Product {

	private String code;
	private String description;
	private double price;
	
	public Product() {
		code = "";
		description = "";
		price = 0.0;
	}

	// we wrote this one in class
	public Product(String inCode, String inDesc, double inPrice) {
		System.out.println("Product constructor w/ 3 parms called");
		code = inCode;
		description = inDesc;
		price = inPrice;
	}
//	this constructor was generated by eclipse
//	public Product(String code, String description, double price) {
//		this.code = code;
//		this.description = description;
//		this.price = price;
//	}

	// I wrote this getter/setter
//	public String getCode() {
//		return code;
//	}
//	
//	public void setCode(String c) {
//		code = c;
//	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + "]";
	}
	
	public static void aStaticMethod() {
		System.out.println("an arbitrary static method");
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


}
