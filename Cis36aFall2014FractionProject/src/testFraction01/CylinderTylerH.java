package testFraction01;

class CylinderTylerH extends CircleTylerH {
	protected FractionTylerH h;

	CylinderTylerH() {
		h = new FractionTylerH();
	}

	CylinderTylerH(CylinderTylerH cyl) {
		h = cyl.h;
	}

	CylinderTylerH(CircleTylerH cir, FractionTylerH height) {
		center = cir.center;
		radius = cir.radius;
		h = height;
	}

	CylinderTylerH(PointTylerH newCen, FractionTylerH newRad, FractionTylerH height) {
		h = new FractionTylerH(height);
		center = newCen;
		radius = newRad;
	//	CircleTylerH tempCir =  new CircleTylerH(center,radius);
		
	}	
	public void print() {
		System.out.println("CENTER");
		center.print();
		System.out.println("RADIUS");
		radius.print();
		System.out.println("HEIGHT");
		h.print();
	}

	@Override
	public FractionTylerH computeArea() {
		FractionTylerH side = ((PI.multiply(radius)).multiply(h)).multiply(new FractionTylerH(2));
		FractionTylerH topBottom = ((radius.multiply(radius)).multiply(PI)).multiply(new FractionTylerH(2));
		return side.add(topBottom);
	}

	@Override
	public FractionTylerH computeVolume() {
		return ((radius.multiply(radius)).multiply(PI)).multiply(h);
	}

}
