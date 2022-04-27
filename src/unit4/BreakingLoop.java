package unit4;

public class BreakingLoop {

	public static void main(String[] args) {

		int i = 0, j = 0;
		outer: for (i = 0; i < 1000; i++) {
			for (j = 0; j < 1000; j++) {
				// you find the element you're looking for
				// and need to brek out, keeping i & j
				if (i == 55 && j == 767) {
					break outer;
				}
			}
		}
		System.out.printf("The coordinates are (%d, %d)", i, j);
	}
}