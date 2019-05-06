
public class StaticMethodDemo {

	public static void main(String[] args) {
		// printWelcomeMessage();
		// printByeMessage();
		int n = 27;
		
		// printMessage("Welcome to my Static Method App", n);
		System.out.println(buildMessage("Welcome to my Static Method App", n));
		String s1 = buildMessage("Bootcamp rocks", n);
		System.out.println(s1);
	
	}

	private static String buildMessage(String s, int j) {
		String str = s + ".  The number is " + j;
		return str;
	}
	private static void printMessage(String s, int j) {
		System.out.println(s+". The number is "+j);
	}
	
	private static void printWelcomeMessage() {
		System.out.println("Welcome to my Static Method App");
	}
	private static void printByeMessage() {
		System.out.println("Bye"); }
}

