/*Andrew Wong
 *Feb.10.22
 *Write a program that uses modulus to print out only the multiples of 13 between 0 and 200.
 */
package unit1;

public class Modulus2 {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 200; i++) {
			if (i % 13 == 0) {
				System.out.printf("%d  ", i);
			}
		}
	}

}