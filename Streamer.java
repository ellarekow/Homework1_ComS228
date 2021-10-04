
public class Streamer extends TownCell {

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {
		// TODO Auto-generated method stub
		this.census(nCensus);
		
		if(nCensus[EMPTY] + nCensus[OUTAGE] <= 1)
			return new Reseller(tNew, this.row, this.col);
		else if(nCensus[RESELLER] > 0)
			return new Outage(tNew, this.row, this.col);
		else if(nCensus[OUTAGE] > 0)
			return new Empty(tNew, this.row, this.col);
		else 
			return new Streamer(tNew, this.row, this.col);
	}

}
