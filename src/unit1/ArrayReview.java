/*Andrew Wong
 * Feb.11.22
 * Makes an array of 12 random numbers from 1-100
 * Finds the largest and smallest number without sorting
 */
package unit1;

public class ArrayReview {

	public static void main(String[] args) {

		int[] numbers = new int[12];
		int largestNum = 0, smallestNum = 100;

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100) + 1;

			if (numbers[i] > largestNum) {
				largestNum = numbers[i];
			}
			if (numbers[i] < smallestNum) {
				smallestNum = numbers[i];
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

		System.out.printf("%n%n");
		System.out.printf("The largest number is %d%n", largestNum);
		System.out.printf("The smallest number is %d", smallestNum);
	}
}