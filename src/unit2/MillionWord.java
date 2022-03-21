/* Andrew Wong
 * Mar.1.22
 * Reads the words from a file and sets the letters of the word to numeric values (a = 1, b = 2, etc)
 * Finds the product of these values
 * Displays the word and the product if the final product is within 1 million +- 500
 * Does the process again, but with the the values reversed (a = 26, b = 25, etc)
 * Displays the total number of words that have a product within 1000000 +- 500 at the end
 */
package unit2;

import java.io.*;
import java.util.Scanner;

public class MillionWord {

	public static void main(String[] args) throws IOException {

		File f = new File("words_alpha.txt");
		BufferedReader br = null;
	
		int wordValue = 0;
		int counter = 0;
		
		System.out.printf("*****************************%n");
		System.out.printf("With A=1, B=2 ...%n%n");
		
		try {
			br = new BufferedReader(new FileReader(f));
			String word = br.readLine();
			// keeps reading file until end of file (null)
			while (word != null) {
				// converts word to character array
				char[] selectedWord = word.toCharArray();
				wordValue = 1;
				
				// calculates product of word
				for (int i = 0; i < selectedWord.length; i++) {
					wordValue = wordValue * (selectedWord[i] - 96);
				}
				
				if (wordValue >= 999500 && wordValue <= 1000500) {
					String oneMillionWord = new String (selectedWord);
					System.out.println(oneMillionWord + " " + wordValue);
					counter++;
				}
				word = br.readLine();
			}
			br.close();
			System.out.println(counter);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.printf("*****************************%n");
		System.out.printf("With A=26, B=25 ...%n%n");
		counter = 0;
		
		try {
			br = new BufferedReader(new FileReader(f));
			String word = br.readLine();
			// keeps reading file until end of file (null)
			while (word != null) {
				// converts word to character array
				char[] selectedWord = word.toCharArray();
				wordValue = 1;
				
				// calculates product of word
				for (int i = 0; i < selectedWord.length; i++) {					
					wordValue = wordValue * ('z' - selectedWord[i] + 1);
				}
				
				if (wordValue >= 999500 && wordValue <= 1000500) {
					String oneMillionWord = new String (selectedWord);
					System.out.println(oneMillionWord + " " + wordValue);
					counter++;
				}
				word = br.readLine();
			}
			br.close();
			System.out.println(counter);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.printf("*****************************");
	}
}