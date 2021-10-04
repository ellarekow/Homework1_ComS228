import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author Ella Rekow
 *
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		//TODO: Write your code here.
		this.length = length;
		this.width = width;
		
		grid = new TownCell[length][width];
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		//TODO: Write your code here.
		File file = new File(inputFileName);
		Scanner in = new Scanner(file);
		
		length = in.nextInt();
		width = in.nextInt();
		
		grid = new TownCell[length][width];
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j< width; j++) {
				char name = in.next().charAt(0);
				
				switch(name){
				case 'C': 
					grid[i][j] = new Casual(this, i , j);
					break;
					
				case 'E':
					grid[i][j] = new Empty(this, i, j);
					break;
					
				case 'O':
					grid[i][j] = new Outage(this, i, j);
					break;
				
				case 'R':
					grid[i][j] = new Reseller(this, i, j);
					break; 
					
				case 'S':
					grid[i][j] = new Streamer(this, i, j);
					break; 
				}
			}
		}
		in.close();
	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		//TODO: Write your code here.
		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j < this.width; j++) {
				int type = rand.nextInt(5);
				switch(type) {
				//how to get the type? 
				case 0:
					grid[i][j] = new Reseller(this, i, j);
					break;
				case 1:
					grid[i][j] = new Empty(this, i, j);
					break;
				case 2:
					grid[i][j] = new Casual(this, i, j);
					break;
				case 3:
					grid[i][j] = new Outage(this, i, j);
					break;
				case 4:
					grid[i][j] = new Streamer(this, i, j);
					break;
				default:
					System.out.println("ERROR: NO SUCH TYPE");
					break;
				}
			}
		}
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		String current = "";
		//TODO: Write your code hsere.
		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j  < this.width; j++) {
				State state = grid[i][j].who();
				
				switch(state) {
				//how to get the type? 
				case RESELLER:
					current = "RESELLER";
					break;
				case EMPTY:
					current = "EMPTY";
					break;
				case CASUAL:
					current = "CASUAL";
					break;
				case OUTAGE:
					current = "OUTAGE";
					break;
				case STREAMER:
					current = "STREAMER";
					break;
				default:
					System.out.println("ERROR: NO SUCH TYPE");
					break;
				}
				
				s += current.substring(0, 1); 
				s += "     ";
			}
			s += "\n";
		}
		return s;
	}
	
	public void nextYear() {
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				grid[i][j] = grid[i][j].next(this);
			}
		}
	}
}

