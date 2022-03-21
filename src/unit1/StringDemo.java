package unit1;

public class StringDemo {

	public static void main(String[] args) {

		String myString = "do you take delight in relishing in the presence of food whilst wearing a blue hat covering your ears?";

		System.out.printf("Length of String = %s%n", myString.length());

		System.out.print("Every other character is: ");
		for (int i = 0; i < myString.length(); i += 2) {
			System.out.print(myString.charAt(i));
		}
		
		int letterCounter = 0;
		for (int i = 0; i < myString.length(); i++) {
			if (myString.charAt(i) == 'u') {
				letterCounter += 1;
			}
		}
		System.out.printf("%nThis String contains the letter u %d times", letterCounter);

		System.out.printf("%nThe first 10 characters are: %s%n", myString.substring(0, 10));

		System.out.print(myString.indexOf('w'));
	}
}
