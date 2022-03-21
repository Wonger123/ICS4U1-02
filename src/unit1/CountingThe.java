/* Andrew Wong
 * Feb.18.22
 * Counts the number of times "the" appears in a String
 * Ignores cases and whether "the" is in another word or on its own
 */
package unit1;

public class CountingThe {

	public static void main(String[] args) {

		String myString = "When the sun rises over the meadow blah blah blah...";

		int theCounter = 0;

		myString.toLowerCase();
		for (int i = 0; i < myString.length() - 2; i++) {
			if (myString.substring(i, i + 3).equals("the")) {
				theCounter++;
			}
		}
		System.out.print(theCounter);
	}
}