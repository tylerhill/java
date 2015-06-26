package testFraction01;

import java.util.Scanner;

public class Cis36aFall2014FractionTylerHDriver {

    public static void main(String[] args) {
        
	
       System.out.println("Class Information -- ");
       System.out.println("  CIS36A - Java Programming");
       System.out.println("  Laney College");
       System.out.println("\n");
       System.out.println("Assignment Information --");
       System.out.println("  Assignment Number: Lab 05 - Exercise #1");
       System.out.println("  Written by:        Tyler Hill");
       System.out.println("  Due Date:          2014/11/4");
        
        
        printMenu();
	menu();



	    
	
	
    }
    public static void menu() {
	Scanner input = new Scanner(System.in);
	RectangleTylerH[] recAry = new RectangleTylerH[2];
	recAry[0]=null;
	recAry[1]=null;
	CircleTylerH[] cirAry = new CircleTylerH[2];
	cirAry[0]=null;
	cirAry[1]=null;
	BoxTylerH[] boxAry = new BoxTylerH[2];
	boxAry[0]=null;
	boxAry[1]=null;
	CylinderTylerH[] cylAry = new CylinderTylerH[2];
	cylAry[0]=null;
	cylAry[1]=null;
	ShapeTylerH[] allSh = new ShapeTylerH[8];
	ShapeTylerH[] initSh;
	//FractionTylerH[] initFr;
       int menuPick;
       int fracUpdate;
	do {
	menuPick = input.nextInt();
		switch (menuPick) {
			case 1:
				//rec
				printSubMenu(menuPick);
				initSh = subMenuCall(menuPick,recAry[0],recAry[1]);
				if(initSh!=null) {
				recAry[0] = (RectangleTylerH) initSh[0];
				recAry[1] = (RectangleTylerH) initSh[1];
				}
				printMenu();
				break;			
			case 2:
				//cir
				printSubMenu(menuPick);
				initSh = subMenuCall(menuPick,cirAry[0],cirAry[1]);
				if(initSh!=null) {
				cirAry[0] = (CircleTylerH) initSh[0];
				cirAry[1] = (CircleTylerH) initSh[1];
				}
				printMenu();
				break;
			case 3:
				//mix
				printSubMenu(menuPick);
				subMenuMixed(menuPick,allSh);
				printMenu();
				break;
			case 4:
				//box
				printSubMenu(menuPick);
				initSh = subMenuCall(menuPick,boxAry[0],boxAry[1]);
				if(initSh!=null) {
				boxAry[0] = (BoxTylerH) initSh[0];
				boxAry[1] = (BoxTylerH) initSh[1];
				}
				printMenu();
				break;
			case 5:
				//cyl
				printSubMenu(menuPick);
				initSh = subMenuCall(menuPick,cylAry[0],cylAry[1]);
				if(initSh!=null) {
				cylAry[0] = (CylinderTylerH) initSh[0];
				cylAry[1] = (CylinderTylerH) initSh[1];
				}
				printMenu();
				break;
			case 6:
				printSubMenu(menuPick);
				subMenuMixed(menuPick,allSh);
				printMenu();
				//all
				break;
			case 7:
				break;
			default: 
				System.out.println("INVALID INPUT");
				printMenu();

		}
	} while(menuPick!=7);
    }


	public static ShapeTylerH initMenu(int shType) {
		Scanner input = new Scanner(System.in);
		int userNum1;
		int userDenom1;
		int userNum2;
		int userDenom2;
		int userNum3;
		int userDenom3;
		int userNum4;
		int userDenom4;
		int denomTest;
		//String[] initOps = {null,"RECTANGLE","CIRCLE"};
		System.out.println("POINT 1 X: NUMERATOR");
		userNum1 = input.nextInt();
		System.out.println("POINT 1 X: DENOMINATOR");
		denomTest = input.nextInt();
		if(denomTest == 0) {
			do {
			System.out.println("CANNOT HAVE DENOMINATOR 0");
			System.out.println("TRY AGAIN");
			System.out.println("FRACTION 1: DENOMINATOR");
			denomTest = input.nextInt();
			} while (denomTest == 0);
			
		}
		userDenom1 = denomTest;

		System.out.println("POINT 1 Y: NUMERATOR");
		userNum2 = input.nextInt();
		System.out.println("POINT 1 Y: DENOMINATOR");
		denomTest = input.nextInt();
		if(denomTest == 0) {
			do {
			System.out.println("CANNOT HAVE DENOMINATOR 0");
			System.out.println("TRY AGAIN");
			System.out.println("FRACTION 2: DENOMINATOR");
			denomTest = input.nextInt();
			} while (denomTest == 0);
			
		}
		userDenom2 = denomTest;

		//type break
		//
		if(shType==1 || shType==4) {
		System.out.println("POINT 2 X: NUMERATOR");
		} else if (shType==2 || shType==5) {
		System.out.println("RADIUS: NUMERATOR");
		}
		userNum3 = input.nextInt();

		if(shType==1 || shType==4) {
		System.out.println("POINT 2 X: DENOMINATOR");
		} else if(shType==2 || shType==5) {
		System.out.println("RADIUS: DENOMINATOR");
		}

		denomTest = input.nextInt();
		if(denomTest == 0) {
			do {
			System.out.println("CANNOT HAVE DENOMINATOR 0");
			System.out.println("TRY AGAIN");
			System.out.println("FRACTION 3: DENOMINATOR");
			denomTest = input.nextInt();
			} while (denomTest == 0);
			
		}
		userDenom3 = denomTest;

		FractionTylerH[] fAry;
		fAry = new FractionTylerH[5];
		fAry[0] = new FractionTylerH(userNum1,userDenom1);
		fAry[1] = new FractionTylerH(userNum2,userDenom2);
		fAry[2] = new FractionTylerH(userNum3,userDenom3);
		fAry[3] = null;
		fAry[4] = null;

		if (shType==1 || shType==4) {
			System.out.println("POINT 2 Y: NUMERATOR");
			userNum4 = input.nextInt();
			System.out.println("POINT 2 Y: DENOMINATOR");
			denomTest = input.nextInt();
			if(denomTest == 0) {
				do {
				System.out.println("CANNOT HAVE DENOMINATOR 0");
				System.out.println("TRY AGAIN");
				System.out.println("FRACTION 4: DENOMINATOR");
				denomTest = input.nextInt();
				} while (denomTest == 0);
				
			}
			userDenom4 = denomTest;
			fAry[3] = new FractionTylerH(userNum4,userDenom4);
		}

//		return init(fAry);
		PointTylerH pt1 = new PointTylerH(fAry[0],fAry[1]);

		//IF 4 OR 5 GET HEIGHT
		if(shType==4 || shType==5) {
			int heightNum;
			int heightDenom;
			System.out.println("HEIGHT: NUMERATOR");
			heightNum = input.nextInt();
			System.out.println("HEIGHT: DENOMINATOR");
			denomTest = input.nextInt();
			if(denomTest == 0) {
				do {
				System.out.println("CANNOT HAVE DENOMINATOR 0");
				System.out.println("TRY AGAIN");
				System.out.println("FRACTION 4: DENOMINATOR");
				denomTest = input.nextInt();
				} while (denomTest == 0);
				
			}
			heightDenom = denomTest;
			fAry[4] = new FractionTylerH(heightNum,heightDenom);

		}

		if (shType==1) {
			PointTylerH pt2 = new PointTylerH(fAry[2],fAry[3]);
	    		return new RectangleTylerH(pt1,pt2);
		} else if(shType==2)  {
			FractionTylerH r = new FractionTylerH(fAry[2]);
	    		return new CircleTylerH(pt1,r);
		} else if(shType==4) {
			PointTylerH pt2 = new PointTylerH(fAry[2],fAry[3]);
			RectangleTylerH baseRec = new RectangleTylerH(pt1,pt2);
			return new BoxTylerH(baseRec,fAry[4]);
		} else if(shType==5) {
			FractionTylerH r = new FractionTylerH(fAry[2]);
	    		CircleTylerH baseCir =  new CircleTylerH(pt1,r);
			return new CylinderTylerH(baseCir,fAry[4]);
		} else {
			return null;
		}

	}

    public static void printMenu() {
	    System.out.println("MAIN MENU");
	    System.out.println("(1) Rectangle Tasks");
	    System.out.println("(2) Circle Tasks");
	    System.out.println("(3) Mixed Rectangle & Circle Tasks");
	    System.out.println("(4) Box Tasks");
	    System.out.println("(5) Cylinder Tasks");
	    System.out.println("(6) All Object Tasks");
	    System.out.println("(7) Quit");
    }

    public static void printSubMenu(int userOp) {
	String userOps[] = {null,"RECTANGLE","CIRCLE","MIXED","BOX","CYLINDER","ALL"};
	String menuOp = userOps[userOp];
	if(userOp==3 || userOp==6) {
	System.out.println("MIXED OBJECT MENU");
	System.out.println("1. Compare by area");
	System.out.println("2. Compare by volume");
	System.out.println("3. Print ALL objects");
	System.out.println("4. Quit");
	} else {
	System.out.println(menuOp+" MENU");
	System.out.println("1. Create two " + menuOp + " objects");
	System.out.println("2. Compare by volume");
	System.out.println("3. Compare by area");
	System.out.println("4. Print two "+menuOp+ " objects");
	System.out.println("5. Quit");
	}

    }

   

    
    public static ShapeTylerH[] subMenuCall(int userOp, ShapeTylerH sh1, ShapeTylerH sh2) {
	Scanner input = new Scanner(System.in);
	if(userOp==3) {
//		int subPick;
//		do {
//		subPick = input.nextInt();
//			switch(subPick) {
//				case 1:
//					break;
//				case 2:
//					break;
//				case 4:
//					printMenu();
//					break;
//				default: 
//					System.out.println("INVALID INPUT");
//					printSubMenu(userOp);
//			}
//		} while (subPick!=4);
	} else {
		int subPick;
		do {
		subPick = input.nextInt();
			switch(subPick) {
				case 1:
					ShapeTylerH[] arySh;
					arySh = new ShapeTylerH[2];
					System.out.println("SHAPE ONE:");
					arySh[0] = initMenu(userOp);
					System.out.println("SHAPE TWO:");
					arySh[1] = initMenu(userOp);
					return arySh;
				case 2:
					if(sh1!=null&&sh2!=null) {
						if(sh1.compareVolume(sh2).getNum()>1) {
							System.out.println(sh1.getClass().getSimpleName()+" (1) is bigger");
						} else if (sh1.compareVolume(sh2).getNum()==0) {
							System.out.println("The shapes have the same area.");
						} else if (sh1.compareVolume(sh2).getNum()<1) {
							System.out.println(sh2.getClass().getSimpleName()+" (2) is bigger");
						}
					} else {
						System.out.println("SHAPES NOT AVAILABLE");
					}
					printSubMenu(userOp);
					break;

				case 3:
					if(sh1!=null&&sh2!=null) {
						if(sh1.compareArea(sh2).getNum()>1) {
							System.out.println(sh1.getClass().getSimpleName()+" (1) is bigger");
						} else if (sh1.compareArea(sh2).getNum()==0) {
							System.out.println("The shapes have the same volume.");
						} else if (sh1.compareArea(sh2).getNum()<1) {
							System.out.println(sh2.getClass().getSimpleName()+" (2) is bigger");
						}
					} else {
						System.out.println("SHAPES NOT AVAILABLE");
					}
					printSubMenu(userOp);
					break;
				case 4:
					if(sh1!=null&&sh2!=null){
					System.out.println(sh1.getClass().getSimpleName() + "(1)");
					sh1.print();
					System.out.println(sh2.getClass().getSimpleName() + "(2)");
					sh2.print();
					} else {
						System.out.println("SHAPES NOT AVAILABLE");
					}
					printSubMenu(userOp);
					break;
				case 5:
					break;
				default: 
					System.out.println("INVALID INPUT");
					printSubMenu(userOp);
			}
		} while (subPick!=5);

	}
		return null;
    }


    public static void subMenuMixed(int userOp, ShapeTylerH[] arySh) {
	Scanner inputMixed = new Scanner(System.in);
	int subPickMixed;
	do {
	subPickMixed = inputMixed.nextInt();
	int objPick1;
	int objPick2;
	int i = 0;
	int picked = 0;
	switch(subPickMixed) {
		case 1:
			for(ShapeTylerH iSh : arySh){
				System.out.println(i);
				iSh.print();
				i++;
			}
			do {
			System.out.println("What is object 1?");
			objPick1 = inputMixed.nextInt();
			System.out.println("What is object 2?");
			objPick2 = inputMixed.nextInt();
			if (arySh[objPick1]!=null&&arySh[objPick2]!=null) 
				picked = 1;
			} while (picked!=1);
			if(arySh[objPick1].compareArea(arySh[objPick2]).getNum()>1) {
					System.out.println(arySh[objPick1].getClass().getSimpleName()+" (1) is bigger");
			} else if(arySh[objPick1].compareArea(arySh[objPick2]).getNum()==0) {
					System.out.println("The shapes have the same area.");
			} else if(arySh[objPick1].compareArea(arySh[objPick2]).getNum()<1) {
					System.out.println(arySh[objPick2].getClass().getSimpleName()+" (1) is bigger");
			}
			
			break;
		case 2:
			for(ShapeTylerH iSh : arySh){
				System.out.println(i);
				iSh.print();
				i++;
			}
			do {
			System.out.println("What is object 1?");
			objPick1 = inputMixed.nextInt();
			System.out.println("What is object 2?");
			objPick2 = inputMixed.nextInt();
			if (arySh[objPick1]!=null&&arySh[objPick2]!=null) 
				picked = 1;
			} while (picked!=1);
			if(arySh[objPick1].compareVolume(arySh[objPick2]).getNum()>1) {
					System.out.println(arySh[objPick1].getClass().getSimpleName()+" (1) is bigger");
			} else if(arySh[objPick1].compareVolume(arySh[objPick2]).getNum()==0) {
					System.out.println("The shapes have the same area.");
			} else if(arySh[objPick1].compareVolume(arySh[objPick2]).getNum()<1) {
					System.out.println(arySh[objPick2].getClass().getSimpleName()+" (1) is bigger");
			}
			printSubMenu(userOp);
			// volume;
			break;
		case 3:
			for(ShapeTylerH iSh : arySh) 
				iSh.print();	
			printSubMenu(userOp);
			break;
		case 4:
			break;
		default:
			System.out.println("INVALID INPUT");
			printSubMenu(userOp);
	}
	} while (subPickMixed!=4);
    }

 
}

