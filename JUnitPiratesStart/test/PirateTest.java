import static org.junit.Assert.*;

import org.junit.Test;

public class PirateTest {

	@Test
	public void createPirateTest() {
		Pirate p1 = new Pirate("Patchy");
		assertEquals("Patchy", p1.getName());
		assertEquals(4, p1.getLimbsRemaining());
	}
	
	@Test
	public void createOctoPirateTest() {
		Pirate p1 = new Pirate("OctoPete", 8);
		assertEquals("OctoPete", p1.getName());
		assertEquals(8, p1.getLimbsRemaining());
		assertEquals(0, p1.getTotalLimbsLost());
	}
	
	@Test
	public void isDeadTest() {
		Pirate p1 = new Pirate ("PirateSteve");
		assertFalse(p1.isDead());
	}

//	@Test(timeout=1000)
//	public void timeoutTest() {
//		while (true);
//	}


}
