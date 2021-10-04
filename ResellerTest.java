import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResellerTest {

	@Test
	void testWho() {
		//Creates the town object 
		Town town = new Town(4, 4);
		town.randomInit(10);
		
		//expected values
		State expected = State.RESELLER;
		State actual = town.grid[0][1].who();
		
		//checks if equal
		assertEquals(actual, expected);
	}
	
	@Test
	void testNext() {
		Town town = new Town(4, 4);
		town.randomInit(10);
		

		State expected = State.EMPTY;
		State actual = town.grid[0][1].next(town).who();
		
		assertEquals(actual, expected);
	}


}
