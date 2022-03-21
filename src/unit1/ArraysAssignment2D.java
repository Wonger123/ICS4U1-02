/*Andrew Wong
 * Feb.15.22
 * 2D Array Assignment
 */
package unit1;

public class ArraysAssignment2D {

	public static void main(String[] args) {

		// double[][] data = new double[10][5];

		// Q3
		int[][] array = new int[3][5];
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				k = k + 1;
				array[i][j] = k;
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%-3d", array[i][j]);
			}
			System.out.println(" ");
		}

		System.out.printf("%n");
		
		// Q4
		// array of 5 rows, 4 columns
		int[][] sales = new int[5][4];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				sales[i][j] = (int) (Math.random() * 250) + 50;
			}
		}

		// displays array sales
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%-4d", sales[i][j]);
			}
			System.out.println(" ");
		}

		// sums every element in array sales
		int grandTotal = 0;
		for (int row = 0; row < sales.length; row++) {
			int rowTotal = 0;
			for (int col = 0; col < sales[row].length; col++) {
				rowTotal += sales[row][col];
			}
			grandTotal += rowTotal;
		}
		System.out.printf("%nGrand total = %d%n", grandTotal);

		// sums every element in the second row
		int row2sum = 0;
		for (int col = 0; col < sales[1].length; col++) {
			row2sum += sales[1][col];
		}
		System.out.printf("Sum of the second row = %d%n", row2sum);

		// sums every element < 50
		int poorSales = 0;
		for (int row = 0; row < sales.length; row++) {
			int lowRowTotal = 0;
			for (int col = 0; col < sales[row].length; col++) {
				if (sales[row][col] < 60) {
					lowRowTotal += sales[row][col];
				}
			}
			poorSales += lowRowTotal;
		}
		System.out.printf("Sum of elements < 50 = %d%n", poorSales);

		// finds the largest value in the array
		int largest = 0;
		for (int row = 0; row < sales.length; row++) {
			for (int col = 0; col < sales[row].length; col++) {
				if (sales[row][col] > largest) {
					largest = sales[row][col];
				}
			}
		}
		System.out.printf("Largest value = %d%n%n", largest);
		
		// Q5
		int[][] data = {
					{3, 2, 5},
					{1, 4, 4, 8, 13},
					{9, 1, 0, 2},
					{0, 2, 6, 3, -1, -8}
        };
		
		// find the sum of each row
		for (int row = 0; row < data.length; row++) {
			System.out.print("Row = " + row + "  ");
			int rowTotal = 0;
			for (int col = 0; col < data[row].length; col++) {
				rowTotal += data[row][col];
			}
			System.out.println("Total = " + rowTotal);
		}
		
		System.out.printf("%n");
		
		// Q6
		int[][] scores = {
						{20, -5, 90, 22, 32},
						{34, 29, -3, 44, 2},
						{100, 0, 96, 37, -0}
		};

		for (int row = 0; row < scores.length; row++) {
			System.out.print("Row = " + row + "  ");
			int rowTotal = 0;
			for (int col = 0; col < scores[row].length; col++) {
				rowTotal += scores[row][col];
			}
			double rowAvg = 0;
			rowAvg = rowTotal / 5.0;
			System.out.println("Average = " + rowAvg);
		}
	}
}