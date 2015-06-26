package testFraction01;

class CircleTylerH extends ShapeTylerH {
	protected PointTylerH center;
	protected FractionTylerH radius;
	final public static FractionTylerH PI = new FractionTylerH(157,50);

	public CircleTylerH() {
		center = new PointTylerH();
		radius = new FractionTylerH();
	}	
	public CircleTylerH(CircleTylerH r) {
		center = new PointTylerH(r.center);
		radius = new FractionTylerH(r.radius);
	}
	public CircleTylerH(PointTylerH rPt1, FractionTylerH fr1) {
		center = rPt1;
		radius = fr1;
	}

	public CircleTylerH(int x, int y, int r) {
		center = new PointTylerH(x,y);
		radius = new FractionTylerH(r); 
	}

	public CircleTylerH(FractionTylerH x, FractionTylerH y, FractionTylerH r) {
		center = new PointTylerH(x,y);
		radius = new FractionTylerH(r);
	}

	public PointTylerH getCenter(CircleTylerH cir) {
		return cir.center;
	}
	
	public FractionTylerH getRadius(CircleTylerH cir) {
		return cir.radius;
	}
	@Override
	public void print() {
		System.out.println("CENTER");
		center.print();
		System.out.println("RADIUS");
		radius.print();
	}

	@Override	
	public FractionTylerH computeArea() {
		return new FractionTylerH(PI.multiply(radius.multiply(radius)));
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
	public FractionTylerH compareVolume(ShapeTylerH sh){
		return new FractionTylerH(0).subtract(sh.computeVolume());
	}
}

