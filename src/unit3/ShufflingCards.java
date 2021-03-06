/* Andrew Wong
 * April.3.22
 * Creates a sorted deck of 52 cards
 * Displays the sorted deck
 * Shuffles the deck
 * Displays the shuffled deck
 */
package unit3;

import java.util.ArrayList;

public class ShufflingCards {

	static ArrayList<Card> deck = new ArrayList<Card>();

	public static void main(String[] args) {

		// creates the deck of cards
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				deck.add(new Card(j, i));
			}
		}

		// displays the sorted deck of cards
		for (int i = 0; i < deck.size(); i++) {
			System.out.printf("%-4s", deck.get(i));
			if (i % 13 == 12) {
				System.out.printf("%n");
			}
		}

		System.out.printf("%n");

		// shuffles the deck of cards
		for (int i = 0; i < deck.size(); i++) {
			int ind = (int) (Math.random() * 52);
			Card a = deck.get(i);
			Card b = deck.get(ind);
			deck.remove(i);
			deck.add(i, b);
			deck.remove(ind);
			deck.add(ind, a);
		}

		// displays shuffled deck of cards
		for (int i = 0; i < deck.size(); i++) {
			System.out.printf("%-4s", deck.get(i));
			if (i % 13 == 12) {
				System.out.printf("%n");
			}
		}
	}
}

class Card {
	public int value;
	public char suit;

	public Card(int cardValue, int cardSuit) {
		value = cardValue;
		if (cardSuit == 1)
			suit = 'H';
		if (cardSuit == 2)
			suit = 'C';
		if (cardSuit == 3)
			suit = 'D';
		if (cardSuit == 4)
			suit = 'S';
	}

	public String toString() {
		String string1;
		if (value == 1)
			string1 = "A";
		else if (value == 11)
			string1 = "J";
		else if (value == 12)
			string1 = "Q";
		else if (value == 13)
			string1 = "K";
		else
			string1 = "" + value;
		return string1 + suit;
	}
}