
public class Outage extends TownCell {
	
	protected Town plain;
	protected int row;
	protected int col;

	public Outage(Town p, int r, int c) {
		super(p, r, c);
		plain = p;
		row = r;
		col = c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town tNew) {
		// TODO Auto-generated method stub
		return new Empty(tNew, this.row, this.col);
	}

}
