package unit1;

public class ArrayQuizQuestion {

	public static void main(String[] args) {

		int[] marks = { 9, 18, 5, 11, 15, 0, 10 };
		int[] marksNew = new int[7];

		for (int i = 0; i < marks.length; i++) {
			marksNew[i] = marks[(i + 2) % 7];
		}

		for (int i = 0; i < marksNew.length; i++) {
			System.out.printf("%d ", marksNew[i]);
		}
	}
}