package testFraction01;

class PointTylerH {
	private FractionTylerH x;
	private FractionTylerH y;

	public PointTylerH() {
		x = new FractionTylerH();
		y = new FractionTylerH();
	}

	public PointTylerH(PointTylerH p) {
		x = new FractionTylerH(p.x);
		y = new FractionTylerH(p.y);
	}
	public PointTylerH(FractionTylerH fr1, FractionTylerH fr2) {
		x = fr1;
		y = fr2;
	}
	public PointTylerH(int xNum, int yNum) {
		x = new FractionTylerH(xNum);
		y = new FractionTylerH(yNum);
	}

	public PointTylerH(int xNum, int xDenom, int yNum, int yDenom) {
		x = new FractionTylerH(xNum,xDenom);
		y = new FractionTylerH(yNum,yDenom);
	}


	public void print() {
		System.out.println("("+x.getNum()+ "/" + x.getDenom() +","+y.getNum()+"/"+y.getDenom()+")");
	}

	public FractionTylerH getX() {
		return x;
	}
	public FractionTylerH getY() {
		return y;
	}


}
