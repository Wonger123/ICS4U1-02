/* Andrew Wong
 * Feb.21.22
 * Makes random 6 letter words with exactly 1 or 2 vowels
 * Number of vowels is randomly decided
 * Location of vowel(s) is random
 */
package unit1;

public class RandomWord {

	public static void main(String[] args) {

		int numOfVowels = (int) (Math.random() * 2) + 1; // number of vowels

		int[] numbers = new int[6];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 26) + 97;

			// re-rolls letter if vowel
			if (numbers[i] == 97 || numbers[i] == 101 || numbers[i] == 105 || numbers[i] == 111 || numbers[i] == 117) {
				while (numbers[i] == 97 || numbers[i] == 101 || numbers[i] == 105 || numbers[i] == 111 || numbers[i] == 117) {
					numbers[i] = (int) (Math.random() * 26) + 97;
				}
			}
		}

		// gets random vowel
		int[] vowels = new int[2];
		for (int x = 0; x < numOfVowels; x++) {
			vowels[x] = (int) (Math.random() * 6);
		}

		// checks if vowels are located in same position
		if (vowels[0] == vowels[1]) {
			while (vowels[0] == vowels[1]) {
				int i = (int) (Math.random() * 2);
				vowels[i] = (int) (Math.random() * 6);
			}
		}

		// selects random vowel
		for (int x = 0; x < numOfVowels; x++) {
			numbers[vowels[x]] = randomVowel();
		}

		// prints out the random letters
		for (int i = 0; i < numbers.length; i++) {
			char c = (char) numbers[i];
			System.out.print(c);
		}
	}

	static int randomVowel() { // chooses random vowel
		int i = (int) (Math.random() * 5) + 1;
		int j = 0;

		if (i == 1)
			j = 97;
		if (i == 2)
			j = 101;
		if (i == 3)
			j = 105;
		if (i == 4)
			j = 111;
		if (i == 5)
			j = 117;
		return j;
	}
}