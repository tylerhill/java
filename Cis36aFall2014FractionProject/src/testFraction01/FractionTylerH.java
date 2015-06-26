package testFraction01;

import java.util.Scanner;
public class FractionTylerH {
    private int num;
    private int denom;
    
    public FractionTylerH() {
    }
    
    public FractionTylerH(FractionTylerH fr) { // copy constructor
        num = fr.num;
        denom = fr.denom;
    }
    public FractionTylerH(int n, int d) {
	if (d < 0) {
		denom = -d;
		num = -n;
	} else {
        num = n;
        denom = d;
	}
    }
    public FractionTylerH(int n) { // int conversion
	num = n;
	denom = 1;
    }
    
    public int getNum() { //accessor
        return num;
    }
    
    public void setNum(int n) { //mutator
        num = n;
    }
    
    public int getDenom() { //accessor
        return denom;
    }
    public void setDenom(int d) {
        denom = d;

    }
    public FractionTylerH add(FractionTylerH fr) {
	    System.out.println("Adding " + this.num + " / " + this.denom + " + "  + fr.num + " / " + fr.denom);
	    int resNum = (this.num * fr.denom) + (this.denom * fr.num);
	    int resDenom = this.denom * fr.denom;
	    return new FractionTylerH(resNum,resDenom);
    }
    public FractionTylerH subtract(FractionTylerH fr) {
	    System.out.println("Subtracting " + this.num + " / " + this.denom + " - "  + fr.num + " / " + fr.denom);
	    int resNum = (this.num * fr.denom) - (this.denom * fr.num);
	    int resDenom = this.denom * fr.denom;
	    return new FractionTylerH(resNum,resDenom);
    }
    public FractionTylerH multiply(FractionTylerH fr) {
	    System.out.println("Multiplying " + this.num + " / " + this.denom + " * "  + fr.num + " / " + fr.denom);
	    int resNum = this.num * fr.num;
	    int resDenom = this.denom * fr.denom;
	    return new FractionTylerH(resNum,resDenom);

    }
    public FractionTylerH divide(FractionTylerH fr) {
	    System.out.println("Dividing " + this.num + " / " + this.denom + " / "  + fr.num + " / " + fr.denom);
	    int resNum = this.num * fr.denom;
	    int resDenom = this.denom * fr.num;
	    return new FractionTylerH(resNum,resDenom);
    }
    public void print() {
	    //System.out.println("CURRENT FRACTION:");
	    System.out.println(this.num + " / " + this.denom);
    }
    public void reduce() {
	    int gcd = gcdRecur(this.num,this.denom);
	    if (gcd<0) {
		    gcd = -gcd;
	    }
	    if(this.denom<0) {
	    System.out.println("denomnegative:"+this.denom);
		    this.num = -this.num;
		    this.denom = -this.denom;
	    }
	    this.num = this.num/gcd;
	    this.denom = this.denom/gcd;
    }
    public static int gcdRecur(int arg1, int arg2) {
	    if(arg1 % arg2 == 0) 
		    return arg2;
	    else
		    return gcdRecur(arg2, arg1 % arg2);
    }
    public void update(int frIndex) {
	Scanner input = new Scanner(System.in);
		int userNum1;
		int userDenom1;
		int userNum2;
		int userDenom2;
		int denomTest;
		System.out.println("FRACTION " + frIndex + " NUMERATOR");
		userNum1 = input.nextInt();
		System.out.println("FRACTION " + frIndex + " DENOMINATOR");
		denomTest = input.nextInt();
		if(denomTest == 0) {
			do {
			System.out.println("CANNOT HAVE DENOMINATOR 0");
			System.out.println("TRY AGAIN");
			System.out.println("FRACTION" + frIndex + " DENOMINATOR");
			denomTest = input.nextInt();
			} while (denomTest == 0);
			
		}
		userDenom1 = denomTest;
		this.num = userNum1;
		this.denom = userDenom1;

    }

}
