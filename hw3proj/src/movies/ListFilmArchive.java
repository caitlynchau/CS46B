package movies;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 * @author Caitlyn Chau
 * CS 46B HW 3
 *
 */
public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {

	/**
	 * add method traverses through all elements in this ArrayList and if object
	 * is not found, adds it to this.
	 */
	public boolean add(Movie m) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals(m)) {
				return false;
			}
		}
		return super.add(m); // calling superclass (ArrayList) add() method
	}

	/**
	 * getSorted method creates a new TreeSet<Movie> object, movieTS which takes
	 * this (ArrayList<Movie>) as a parameter. movieTS will sort all the objects
	 * based on deep equality.
	 * 
	 * @return ArrayList of Movies sorted by title then year
	 */
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> movieTS = new TreeSet<Movie>(this);
		return new ArrayList<Movie>(movieTS);
	}

	/**
	 * main method tests ListFilmArchive with an array of test movies. First
	 * calls add method which will sort out any duplicates. Then calls getSorted
	 * method, which uses a TreeSet to sort movies in order by title then year.
	 * 
	 * @param args - argument
	 */
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		System.out.println("Original movie array with no duplicates");
		for (Movie m : Movie.getTestMovies()) {
			archive.add(m);
		}
		for (Movie m : archive) {
			System.out.println(m);
		}
		System.out.println("******************");
		for (Movie m : archive.getSorted()) {
			System.out.println(m);
		}
	}
}
