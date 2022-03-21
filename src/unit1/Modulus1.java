/*Andrew Wong
 *Feb.10.22
 *Write a program that will print out the numbers 0-100 in the first column
 *along with the numbers 0-7 cycling in the second column.
 */
package unit1;

public class Modulus1 {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 100; i++) {
			System.out.printf("%-3d   ", i);
			System.out.println(i % 8);
		}
	}

}