package testFraction01;

import java.util.Scanner;


public class FractionTylerHUtility {
    public static FractionTylerH addFractionTylerH(FractionTylerH fr1, FractionTylerH fr2) {
        
        return new FractionTylerH(fr1.getNum() * fr2.getDenom() + fr1.getDenom() * fr2.getNum(),
            fr1.getDenom() * fr2.getDenom());
    }

    public static FractionTylerH subtractFractionTylerH(FractionTylerH fr1, FractionTylerH fr2) {
        return new FractionTylerH(fr1.getNum() * fr2.getDenom() - fr1.getDenom() * fr2.getNum(),
            fr1.getDenom() * fr2.getDenom());
    }
   
    public static FractionTylerH multiplyFractionTylerH(FractionTylerH fr1, FractionTylerH fr2) {
	    return new FractionTylerH(fr1.getNum() * fr2.getNum(), fr1.getDenom() * fr2.getDenom());
    }
    public static FractionTylerH divideFractionTylerH(FractionTylerH fr1, FractionTylerH fr2) {

	    return new FractionTylerH(fr1.getNum() * fr2.getDenom(), fr1.getDenom() * fr2.getNum()); 
    }
    public static void print(FractionTylerH fr) {
        System.out.println("\n\t" + fr.getNum() + " / " + fr.getDenom());
    }

    public static FractionTylerH reduceFractionTylerH(FractionTylerH fr) {
	int num = fr.getNum();
	int denom = fr.getDenom();
	int gcd = gcdRecur(num,denom);
 		return new FractionTylerH(num / gcd, denom / gcd);

    }

    public static int gcdRecur(int arg1, int arg2) {
	    if(arg1 % arg2 == 0) 
		    return arg2;
	    else
		    return gcdRecur(arg2, arg1 % arg2);
    }

}

