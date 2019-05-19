import static org.junit.Assert.*;

import org.junit.Test;

import business.Function;

public class CalculatorTest {

	@Test
	public void additionTest() {
		Function f1 = new Function();
		assertEquals(10, f1.addition(5, 5));
	}
	
	@Test
	public void subtractionTest() {
		Function f1 = new Function();
		assertEquals(15, f1.subtraction(20, 5));
	}
	
	@Test
	public void multiplicationTest() {
		Function f1 = new Function();
		assertEquals(100, f1.multiplication(20, 5));
	}
	
	@Test
	public void divisionTest() {
		Function f1 = new Function();
		assertEquals(100, f1.division(500, 5), 0.0000001);
	}
	
	@Test
	public void modulusTest() {
		Function f1 = new Function();
		assertEquals(2, f1.modulus(12, 5));
	}

}
