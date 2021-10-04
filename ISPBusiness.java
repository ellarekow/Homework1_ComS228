
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author <<Write your name here>>
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		//TODO: Write your code here.
		for(int i = 0; i < tOld.getWidth(); i++) {
			for(int j = 0; j < tOld.getWidth(); j++) {
				tOld.grid[i][j].next(tNew);
			}
		}
		return tNew;
	}
	

	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		//TODO: Write/update your code here.
		int cas = 0;
		
		for(int i = 0; i < town.getLength(); i++) {
			for(int j = 0; j < town.getWidth(); j++) {
				if(town.grid[i][j].who() == State.CASUAL)
					cas++;
			}
		}
		
		return cas;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) {
		//TODO: Write your code here.
		
//		Town town = new Town(6, 6);
//		town.randomInit(6);
//		System.out.println(town.toString());
////		
//		town.nextYear();
//		
////		System.out.println("12 month cycle:");
//		for(int i = 0; i < 11; i++) {
//			System.out.println("month : " + (i +1));
//			town.nextYear();
//			System.out.println(town.toString());
//		}
		
		Town town = null;
		
		int profit = 0;
		int type = 0;
		
		Scanner in = new Scanner(System.in);
		
		try {
			System.out.println("What type of town would you like to generate?");
			System.out.println("1. Randomly Generated");
			System.out.println("2. From a file");
			System.out.println("(please type in \"1\" or \"2\")");
			
			type = in.nextInt();
			
			if(type == 1) {
				System.out.println("Enter a size:");
				int length = in.nextInt();
				System.out.println("Enter a width:");
				int width = in.nextInt();
				
				town = new Town(length, width);
				
				System.out.println("Please include a seed");
				int seed = in.nextInt();
				town.randomInit(seed);
			}
			
			if(type == 2) {
				System.out.println("Please enter a file path:");
				
				String filePath = in.next();
				
				town = new Town(filePath);
			}
			
			profit += getProfit(town);
		
			for(int i = 0; i < 11; i++) {
				town.nextYear();
				profit += getProfit(town);
			}
			
			System.out.println("Profit is: ");
			double fullProfit = ((profit) / (town.getLength() * town.getWidth() * 12.00)) * 100.00;
			System.out.printf("%.2f", fullProfit);
			System.out.println("%");
		
		}catch (Exception e) {
			System.out.println("This is not a valid input");
		}
		
		in.close();
	}
}
