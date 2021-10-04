import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TownTest {

	@Test
	void testGetWidth() {
		Town town = new Town(4, 4);
		town.randomInit(10);
		
		assertEquals(4, town.getWidth());
	}
	
	@Test
	void testgetLength() {
		Town town = new Town(4, 4);
		town.randomInit(10);
		
		assertEquals(4, town.getLength());
	}
	
	@Test
	void testRandomInit() {
		Town town = new Town(4, 4);
		town.randomInit(10);
		
		String actual;
		
		String expected = "OROR\n" + "EECO\n" + "ESOS\n" + "EORR\n";
		
		actual = town.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testToString() {
		Town town = new Town(4,4);
		town.randomInit(10);
		
		String actual; 
		
		String expected = "OROR\n" + "EECO\n" + "ESOS\n" + "EORR\n";
		
		actual = town.toString();
		
		assertEquals(expected, actual);
	}

}
