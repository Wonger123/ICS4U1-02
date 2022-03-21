package unit1;

public class Array2D {

	public static void main(String[] args) {

		int[][] data = {
						{ 4, 5, 6, 7 },
						{ 1, 2, 0, 8 },
						{ 3, 8, 8, 1 },
		};

		// find the biggest number in each row
		for (int row = 0; row < data.length; row++) {
			System.out.print("Row = " + row + "  ");
			int big = -999999;
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] > big)
					big = data[row][col];
			}
			System.out.println("Biggest = " + big);
		}

		// find totals for each row
		for (int row = 0; row < data.length; row++) {
			System.out.print("Row = " + row + "  ");
			int total = 0;
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
			System.out.println("Total = " + total);
		}
	}
}