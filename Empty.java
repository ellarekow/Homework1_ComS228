
public class Empty extends TownCell {
	protected Town plain;
	protected int row;
	protected int col;

	public Empty(Town p, int r, int c) {
		super(p, r, c);
		plain = p;
		row = r;
		col = c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew) {
		this.census(nCensus);
		
		if((nCensus[EMPTY] + nCensus[OUTAGE]) <= 1) 
			return new Reseller(tNew, this.row, this.col);
		else
			return new Casual(tNew, this.row, this.col);
	}

}
