
/**
 * 
 * @author Ella Rekow
 *	Also provide appropriate comments for this class
 *
 */
public class Casual extends TownCell {
	
	protected Town plain;
	protected int row;
	protected int col;
	
	public Casual(Town p, int r, int c) {
		super(p, r, c);
		plain = p;
		row = r;
		col = c;
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
		// TODO Auto-generated method stub
		this.census(nCensus);
		
		if(nCensus[RESELLER] > 0)
			return new Outage(tNew, this.row, this.col);
		else if(nCensus[STREAMER] > 0 || nCensus[CASUAL] >= 5) 
			return new Streamer(tNew, this.row, this.col);
		else if(nCensus[EMPTY] + nCensus[OUTAGE] <= 1)
			return new Reseller(tNew, this.row, this.col);
		else
			return new Casual(tNew, this.row, this.col);
	}
}
