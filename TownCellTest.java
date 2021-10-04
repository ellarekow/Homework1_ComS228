import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TownCellTest {

	@Test
	void TestCensus() {
		Town town = new Town(4, 4);
		town.randomInit(10);
		
		TownCell cell = new Empty(town, 1, 1);
		
		int[] expected = {1, 2, 1, 3, 1};
		int[] actual = new int[5];
		
		cell.census(actual);
		
		assertEquals(actual[0], expected[0]);
		assertEquals(actual[1], expected[1]);
		assertEquals(actual[2], expected[2]);
		assertEquals(actual[3], expected[3]);
		assertEquals(actual[4], expected[4]);
	}
}
