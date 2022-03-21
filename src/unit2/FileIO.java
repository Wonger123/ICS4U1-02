/* Andrew Wong
 * Feb.28.22
 * Reads and prints the first 15 lines of the file "words_alpha.txt" using BufferedReader and Scanner
 */
package unit2;

import java.io.*;
import java.util.Scanner;

public class FileIO {

	public static void main(String[] args) {

		File f = new File("words_alpha.txt");
		BufferedReader brFile = null;

		try {
			brFile = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
		}

		for (int i = 0; i < 15; i++) {
			try {
				String word = brFile.readLine();
				System.out.println(word);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("%n");

		try {
			Scanner sc = new Scanner(f);
			for (int i = 0; i < 15; i++) {
				if (sc.hasNextLine()) {
					String line = sc.nextLine();
					System.out.println(line);
				}
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}