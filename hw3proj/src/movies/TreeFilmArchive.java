package movies;

import java.util.TreeSet;
import java.util.ArrayList;

/**
 * 
 * @author Caitlyn Chau
 * CS 46B HW 3
 * 
 * TreeFilmArchive is a TreeSet<Movie> object that implements FilmArchive. 
 * It removes duplicates and sorts its elements in order by title, then by year.
 *
 */
public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {

	/**
	 * getSorted method() returns this object (TreeSet<Movie>) as an ArrayList.
	 * The ArrayList will be sorted with no duplicates and by title, then year
	 * as determined by compareTo() method written earlier.
	 */
	public ArrayList<Movie> getSorted() {
		return new ArrayList<Movie>(this);
	}

	/**
	 * Do not need to create add() method because the superclass, TreeSet<Movie>
	 * already contains add() method which "adds the specified element to this
	 * set if it is not already present" (Java API).
	 */
	
	
	/**
	 * Main method tests TreeSet's order
	 * @param args - argument
	 */
	public static void main(String[]args){
		TreeFilmArchive archive = new TreeFilmArchive();
		for (Movie m : Movie.getTestMovies()){
			archive.add(m); 
		}
		for (Movie m: archive){
			System.out.println(m);
		}
		System.out.println("******************");
		for (Movie m : archive.getSorted()){
			System.out.println(m);
		}
	}

}
