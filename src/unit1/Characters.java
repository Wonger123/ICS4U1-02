package unit1;

public class Characters {

	public static void main(String[] args) {
		
		char c = 'A';
		c++;
		int n = c;
		
		System.out.printf("c=%c, n=%d%n%n", c, n);
		
		for (int i = 0; i <26; i++) {
			System.out.print((char)('A' + i));
		}
	}
}