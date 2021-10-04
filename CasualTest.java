import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CasualTest {

	@Test
	void testWho() {
		//Creates the town object 
		Town town = new Town(4, 4);
		town.randomInit(10);
		
		//expected values
		State expected = State.CASUAL;
		State actual = town.grid[1][2].who();
		
		//checks if equal
		assertEquals(actual, expected);
	}
	
	@Test
	void testNext() {
		Town town = new Town(4, 4);
		town.randomInit(10);
		

		State expected = State.OUTAGE;
		State actual = town.grid[1][2].next(town).who();
		
		assertEquals(actual, expected);
	}

}
