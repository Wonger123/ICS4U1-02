/*Andrew Wong
 * Mar.21.22
 * Creates objects for 8 movies containing the name, genre, release date, and runtime in minutes
 * Objects are stored in an ArrayList and printed out
 * Movies with a runtime less than 120 minutes are removed and the new list is printed out
 * 
 * Both classes are in this single file for less clutter when submitting
 */
package unit3;

import java.util.ArrayList;

public class ArrayListAssignment {

	public static void main(String[] args) {

		ArrayList<Movie> movieList = new ArrayList<Movie>();

		// 1. add movies
		movieList.add(new Movie("Infinity War", "Action", 2018, 149));
		movieList.add(new Movie("Avengers: Endgame", "Action", 2019, 182));
		movieList.add(new Movie("Iron Man", "Action", 2008, 126));
		movieList.add(new Movie("Minions", "Family", 2015, 91));
		movieList.add(new Movie("Star Wars: Episode IV", "Sci-fi", 1977, 105));
		movieList.add(new Movie("The Incredibles", "Family", 2004, 115));
		movieList.add(new Movie("Dune", "Sci-fi", 2021, 155));
		movieList.add(new Movie("Pacific Rim", "Action", 2013, 131));

		// 2. display movies
		System.out.printf("%-25s %-8s %14s%10s%n%n", "Title", "Genre", "Release Date", "Runtime");

		for (Movie m : movieList) {
			System.out.printf("%-25s %-10s %-14d %-2dmin%n", m.title, m.genre, m.releaseDate, m.runtime);
		}

		// 3. remove movies with a runtime < 120min
		for (int i = 0; i < movieList.size(); i++) {
			Movie m = movieList.get(i);

			if (m.runtime < 120) {
				movieList.remove(i);
				i--;
			}
		}

		System.out.println("***********************************************************");

		// 4. display new list
		System.out.printf("%-25s %-8s %14s%10s%n%n", "Title", "Genre", "Release Date", "Runtime");

		for (int i = 0; i < movieList.size(); i++) {
			Movie m = movieList.get(i);
			System.out.printf("%-25s %-10s %-14d %-2dmin%n", m.title, m.genre, m.releaseDate, m.runtime);
		}
	}
}

class Movie {
	
	String title;
	String genre;
	int releaseDate;
	int runtime;

	Movie() {};
	Movie(String title, String genre, int releaseDate, int runtime) {
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.runtime = runtime;
	}
}