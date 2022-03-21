/*Andrew Wong
 * Feb.16.22
 * Array of 15 random numbers from 1-100
 * Sorted using SELECTION sort
 */
package unit1;

public class SortingArrays {

	public static void main(String[] args) {

		int[] nums = new int[15];
		
		//unsorted array
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 100) + 1;
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

		System.out.printf("%n%n");

		//sorted array
		for (int i = 0; i < nums.length; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			int swap = nums[i];
			nums[i] = nums[min];
			nums[min] = swap;
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}