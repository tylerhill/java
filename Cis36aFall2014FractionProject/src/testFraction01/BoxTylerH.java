package testFraction01;

class BoxTylerH extends RectangleTylerH {
	protected FractionTylerH h;
	
	public BoxTylerH() {
		h = new FractionTylerH();
	}
	public BoxTylerH(BoxTylerH bx){
		h = bx.h;
		upperRight = bx.upperRight;
		lowerLeft = bx.lowerLeft;
	}
	public BoxTylerH(RectangleTylerH rec, FractionTylerH height) {
		upperRight = rec.upperRight;
		lowerLeft = rec.lowerLeft;
		h = height;
	}

	public void print() {
		upperRight.print();
		lowerLeft.print();
		h.print();
	}

	@Override
	public FractionTylerH computeArea(){
		// 2lw + 2wh + 2lh
		l = (upperRight.getX()).subtract(lowerLeft.getX());
		w = (upperRight.getY()).subtract(lowerLeft.getY());
		FractionTylerH lW2 = (l.multiply(w)).multiply(new FractionTylerH(2));
		FractionTylerH lH2 = (l.multiply(h)).multiply(new FractionTylerH(2));
		FractionTylerH wH2 = (w.multiply(h)).multiply(new FractionTylerH(2));

		return (lW2.add(lH2)).add(wH2);
	}

	@Override
	public FractionTylerH compareArea(ShapeTylerH sh) {
		return computeArea().subtract(sh.computeArea());
	}

	@Override
	public FractionTylerH computeVolume() {
		l = (upperRight.getX()).subtract(lowerLeft.getX());
		w = (upperRight.getY()).subtract(lowerLeft.getY());
		return (l.multiply(w)).multiply(h);
	}

	@Override
	public FractionTylerH compareVolume(ShapeTylerH sh) {
		return computeVolume().subtract(sh.computeVolume());
	}
}
