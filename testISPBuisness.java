import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testISPBuisness {

	@Test
	void testUpdatePlain() {
		Town town = new Town(4, 4);
		Town town2 = new Town(4, 4);
		
		town.randomInit(10);
		
		String actual; 
		
		String expected = "E E E E \n" + "C C O E \n" + "C O E O \n" + "C E E E \n";
		
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				town2.grid[i][j] = town.grid[i][j].next(town2);
			}
		}
		
		actual = town2.toString();
		
		assertEquals(expected, actual);
	}
	
	void testGetProfit() {
		Town town = new Town(4, 4);
		town.randomInit(10);
		
		int expected = 1;
		
		int actual = 0;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(town.grid[i][j].who() == State.CASUAL);
					actual++;
			}
		}
		assertEquals(expected, actual);
	}
	
}
