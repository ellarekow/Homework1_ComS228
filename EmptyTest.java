import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmptyTest {
	
	@Test
	void testWho() {
		//Creates the town object 
		Town town = new Town(4, 4);
		town.randomInit(10);
		
		//expected values
		State expected = State.EMPTY;
		State actual = town.grid[1][1].who();
		
		//checks if equal
		assertEquals(actual, expected);
	}
	
	@Test
	void testNext() {
		Town town = new Town(4, 4);
		town.randomInit(10);
		

		State expected = State.CASUAL;
		State actual = town.grid[1][1].next(town).who();
		
		assertEquals(actual, expected);
	}

}
