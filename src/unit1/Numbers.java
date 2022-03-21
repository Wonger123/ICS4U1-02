/* Andrew Wong
 * Feb.18.22
 * Increases each integer in a String by 1
 * 9 becomes 0 instead of 10
 */
package unit1;

public class Numbers {

	public static void main(String[] args) {

		String myString = "abc351def90";

		System.out.println(myString);

		for (int i = 0; i < myString.length(); i++) {
			char c = myString.charAt(i);
			int a = c;

			if (a == 57) {
				a = 48;
			} else if (a > 47 && a < 57) {
				a += 1;
			}

			char cc = (char) a;

			System.out.print(cc);
		}
	}
}