/*Andrew Wong
 *Feb.10.22 */
package unit1;

public class ModulusAssignment {

	public static void main(String[] args) {
		
		/*Write a program that will print out the numbers 0-100 in the first column
		 *along with the numbers 0-7 cycling in the second column.*/
		System.out.println("Modulus1.java");
		for (int i = 0; i <= 100; i++) {
			System.out.printf("%-3d   %d%n", i,i%8);
		}
		System.out.printf("%n");

		/*Write a program that uses modulus to print out only the multiples of 13 between 0 and 200.*/
		System.out.println("Modulus2.java");
		for (int i = 1; i <= 200; i++) {
			if (i % 13 == 0) {
				System.out.printf("%d  ", i);
			}
		}
		System.out.printf("%n%n");
		
		/*Write a program that prints out the numbers from 1 to 200. Use modulus to insert a newline character after every multiple of 12.*/
		System.out.println("Modulus3.java");
		for (int x = 1; x <= 200; x++) {
			System.out.printf("%4d", x);
			if (x % 12 == 0) {
				System.out.printf("%n");
			}
		}
	}
}