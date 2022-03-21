/*Andrew Wong
 *Feb.10.22
 *Write a program that prints out the numbers from 1 to 200. Use modulus to insert a newline character after every multiple of 12.
 */
package unit1;

public class Modulus3 {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 200; i++) {
			System.out.printf("%4d", i);
			if (i % 12 == 0) {
				System.out.printf("%n");
			}
		}
	}

}