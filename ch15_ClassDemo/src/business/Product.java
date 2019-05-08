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

	public Product(String inCode, String inDesc, double inPrice) {
		code = inCode;
		description = inDesc;
		price = inPrice;
	}
//	// Sean wrote this getter/setter
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


}
