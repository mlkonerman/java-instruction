import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAndAfterTest {

	@Test
	public void test1() {
		System.out.println("test 1 called");
	}
	@Test
	public void test2() {
		System.out.println("test 2 called");
	}
	@Test
	public void test3() {
		System.out.println("test 3 called");
	}
	@Before
	public void before() {
		System.out.println("before called");
	}
	@After
	public void after() {
		System.out.println("after called");
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class called");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("after class called");
	}


}
