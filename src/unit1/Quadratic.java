/*Andrew Wong
 * Feb.11.22
 * Calculates the roots using the quadratic formula from user input
 */
package unit1;

import java.util.Scanner;

public class Quadratic {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		double x1 = 0, x2 = 0;

		System.out.print("Enter the value of a: ");
		double a = getDouble();

		System.out.print("Enter the value of b: ");
		double b = getDouble();

		System.out.print("Enter the value of c: ");
		double c = getDouble();

		double discrim = (b * b) - (4 * a * c);

		if (discrim < 0) {
			System.out.println("No roots");
		}
		if (discrim == 0) {
			x1 = -b / (2 * a);
			System.out.print("One root x = " + x1);
		}
		if (discrim > 0) {
			x1 = (-b + Math.sqrt(discrim)) / (2 * a);
			x2 = (-b - Math.sqrt(discrim)) / (2 * a);
			System.out.printf("x1 = %-8.4f x2 = %-8.4f", x1, x2);
		}
	}

	static double getDouble() {
		while (!sc.hasNextDouble()) {
			sc.nextDouble();
		}

		return sc.nextDouble();
	}
}