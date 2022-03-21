package unit1;

public class MathStuff {

	public static void main(String[] args) {
		
		System.out.println("Strange math");
		
		double d = 5.0/2;
		System.out.println(d);
		
		//Let's STOP here!
		//System.exit(0);
		//OR
		//if (1 == 1) return;
		
		int m = 5;
		//int n = 5/0; //Bad bad bad. Will crash
		//System.out.println("n = " = n);

		double x = 5.0;
		double y = x / 0.0;
		double z = y*y; //infinity x infinity
		System.out.println("y = " + y);
		System.out.println("z = " + z);
		//if (y == z) System.out.println("same infinity");
		
		System.out.printf("y = %f and z = %f. Are they equal? %b%n",y,z, y==z);
		
		//other invalid math
		x = Math.sqrt(-5.0);
		System.out.println("x = " + x);
		y = Math.asin(2.0);
		System.out.println("y = " + y);
		if (x == y) System.out.println("same NaN");
		
		//big integers
		int big = 2_147_483_647; //commas to _
		big ++;
		System.out.println(big);
		System.out.println(5_000_000 * 30_000);
		
		long num = 5_000_000L * 30_000L;
		System.out.println(num);
		
		//big doubles
		x = 1.7e+308;
		x = x * 10;
		System.out.println("bigger than biggest double: " + x);
		
		//accuracy
		x = 1234.0;
		x = x / 10;
		x = x / 10;
		System.out.println("x is now " + x);
		
		//how to check if two doubles are equal
		if (x == 12.34) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
		
		if (Math.abs(x - 12.34) < 0.00000001) System.out.println("EQUAL!");
	}
}
