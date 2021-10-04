
public class Reseller extends TownCell {

	protected Town plain;
	protected int row;
	protected int col;
	
	public Reseller(Town p, int r, int c) {
		super(p, r, c);
		plain = p;
		row = r;
		col = c;
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		this.census(nCensus);
		
		if(nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3)
			return new Empty(tNew, this.row, this.col);
		else if(nCensus[CASUAL] > 5)
			return new Streamer(tNew, this.row, this.col);
		else
			return new Reseller(tNew, this.row, this.col);
	}

}
