public class CalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator App!");
		System.out.println("");
		System.out.println("When x=15 and y=2:");
		System.out.println("");
			int x = 15;
			int y = 2;
			int result1 = x + y;
			int result2 = x - y;
			int result3 = x * y;
			int result4 = x / y;
		System.out.print("x + y = "); System.out.println(result1);
		System.out.print("x - y = "); System.out.println(result2);
		System.out.print("x * y = "); System.out.println(result3);
		System.out.print("x / y = "); System.out.println(result4);
		System.out.print("(x + y) + (x - y) = "); System.out.println(result1 + result2);
	}
}
