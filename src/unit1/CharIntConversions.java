package unit1;

public class CharIntConversions {

	public static void main(String[] args) {

		// 1. int to char : cast (A == 65, a == 97)
		int n = 66;
		char cc = (char) n;
		// System.out.println(n + " -> '" + cc + "'"); // let's switch to printf to make
		// it look nicer
		System.out.printf("%2d -> '%c'%n%n", n, cc);

		// 2. char to int : Just do it!
		cc = 'E';
		n = cc;
		// System.out.println("'" + cc +"' -> " + n);
		System.out.printf("'%c'-> %2d%n%n", cc, n);

		// 3. Make 1=A, 2=B : add A-1 (because we don't want A to be zero)
		n = 4; // change to D and d

		cc = (char) (n + 'A' - 1);
		System.out.printf("%2d -> '%c'%n", n, cc);
		cc = (char) (n + 'a' - 1);
		System.out.printf("%2d -> '%c'%n%n", n, cc);

		// 4. Change A to 1, B to 2 ... : opposite of above
		cc = 'J';
		n = cc - 'A' + 1; // should be 10
		System.out.printf("'%c'-> %2d%n%n", cc, n);

		// 5. Change int digit to char digit : add the value of '0' ('0'==48)
		n = 3;
		cc = (char) (n + '0');
		System.out.printf("%2d -> '%c'%n%n", n, cc);

		// 6. change char digit to int digit : subtract the value of '0'
		cc = '7';
		n = cc - '0';
		System.out.printf("'%c'-> %2d%n", cc, n);
	}
}
