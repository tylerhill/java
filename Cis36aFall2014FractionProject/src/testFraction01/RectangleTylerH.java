package testFraction01;

class RectangleTylerH extends ShapeTylerH {
	protected PointTylerH upperRight;    
	protected PointTylerH lowerLeft;

	protected FractionTylerH w; // = urX.subtract(llX);
	protected FractionTylerH l; // = urY.subtract(llY);
	
	public RectangleTylerH() {
		upperRight = new PointTylerH();
		lowerLeft = new PointTylerH();
	}	
	public RectangleTylerH(RectangleTylerH r) {
		upperRight = new PointTylerH(r.upperRight);
		lowerLeft = new PointTylerH(r.lowerLeft);
	}
	public RectangleTylerH(PointTylerH pt) {
		upperRight = pt;
		lowerLeft = new PointTylerH(0,0);
	}
	public RectangleTylerH(PointTylerH rPt1, PointTylerH rPt2) {
		upperRight = rPt1;
		lowerLeft = rPt2;
	}

	public RectangleTylerH(FractionTylerH uRX, FractionTylerH uRY, FractionTylerH lLX, FractionTylerH lLY) {
		upperRight = new PointTylerH(uRX,uRY);
		lowerLeft = new PointTylerH(lLX,lLY);
	}

	public RectangleTylerH(int[] ptInts) {
		upperRight = new PointTylerH(ptInts[0],ptInts[1],ptInts[2],ptInts[3]);	
		lowerLeft = new PointTylerH(ptInts[4],ptInts[5],ptInts[6],ptInts[7]);	
	}

	public PointTylerH getUr(RectangleTylerH rec) {
		return rec.upperRight;
	}

	public PointTylerH getLl(RectangleTylerH rec) {
		return rec.lowerLeft;
	}
	@Override
	public void print() {
		upperRight.print();
		lowerLeft.print();
	}
	@Override	
	public FractionTylerH computeArea() {
		l = (upperRight.getX()).subtract(lowerLeft.getX());
		w = (upperRight.getY()).subtract(lowerLeft.getY());

		return new FractionTylerH(l.getNum() * w.getNum(), l.getDenom() * w.getDenom());
	}
	@Override
	public FractionTylerH compareArea(ShapeTylerH sh) {
		return computeArea().subtract(sh.computeArea());
	}

	@Override
	public FractionTylerH computeVolume(){
		//System.out.println("Volume not available");
		return new FractionTylerH(0);
	}
	@Override
	public FractionTylerH compareVolume(ShapeTylerH sh) {
		return new FractionTylerH(0).subtract(sh.computeVolume());
	}

}
