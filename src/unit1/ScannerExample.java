package unit1;

import java.util.Scanner;

public class ScannerExample {

	//global variable
	static Scanner sc = new Scanner(System.in);
	 
	public static void main(String[] args) {
		System.out.print("What do you have for lunch? ");
		String food = sc.next(); //we only want 1 word
		sc.nextLine(); //clear the rest of the input
		System.out.println("I like " + food + " too... yum");
		
		System.out.print("How many pieces do you have? ");		
		int num = getInt();
		
		if (num > 1) {
			System.out.println("Can I buy one? I have 25¢");
		}
	}
	
	static int getInt() {
		while(!sc.hasNextInt()) {
			System.out.print("Please enter an integer");
			sc.nextLine(); //clear the input
		}
		return sc.nextInt();		
	}
}