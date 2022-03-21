package unit1;

public class SplittingDigits {

	public static void main(String[] args) {
		
		int n = 74;
		/*
		int a = n/10;
		int b = n%10;
		System.out.printf("a=%d, b=%d%n", a, b);
		
		double d = n/10.0;
		aa = (int)d;
		bb = n - a*10;
		System.out.printf("a=%d, b=%d%n", aa, bb);
		*/
		//number --> String
		String s = "" + n;
		int aaa = Character.getNumericValue(s.charAt(0));
		int bbb = Character.getNumericValue(s.charAt(1));
		System.out.printf("int a = %d, int b = %d%n", aaa, bbb);
	}
}